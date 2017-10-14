package com.twhc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.twhc.R;
import com.twhc.resources.EnquiryDetail.EnquiryRequest;
import com.twhc.resources.EnquiryDetail.EnquiryResponse;
import com.twhc.resources.EnquiryDetail.EnquiryService;
import com.twhc.utility.Utility;
import com.twhc.web.BaseApiCallback;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.editsoft.api.exception.APIException;

/**
 * Created by Gaurav on 12/10/17.
 */

public class EnquiryActivity extends BaseActivity {

    @BindView(R.id.input_name)
    EditText inputName;
    @BindView(R.id.input_layout_name)
    TextInputLayout inputLayoutName;
    @BindView(R.id.input_email)
    EditText inputEmail;
    @BindView(R.id.input_layout_email)
    TextInputLayout inputLayoutEmail;
    @BindView(R.id.input_password)
    EditText inputPassword;
    @BindView(R.id.input_layout_password)
    TextInputLayout inputLayoutPassword;
    @BindView(R.id.input_company)
    EditText inputCompany;
    @BindView(R.id.input_layout_Company)
    TextInputLayout inputLayoutCompany;
    @BindView(R.id.input_address)
    EditText inputAddress;
    @BindView(R.id.input_layout_Address)
    TextInputLayout inputLayoutAddress;
    @BindView(R.id.input_city)
    EditText inputCity;
    @BindView(R.id.input_layout_city)
    TextInputLayout inputLayoutCity;
    @BindView(R.id.input_state)
    EditText inputState;
    @BindView(R.id.input_layout_state)
    TextInputLayout inputLayoutState;
    @BindView(R.id.input_country)
    EditText inputCountry;
    @BindView(R.id.input_layout_country)
    TextInputLayout inputLayoutCountry;
    @BindView(R.id.input_details)
    EditText inputDetails;
    @BindView(R.id.input_layout_details)
    TextInputLayout inputLayoutDetails;
    @BindView(R.id.btn_signup)
    Button btnSignup;

    String name, email, phoneno, company, address, city, state, country, details;
    @BindView(R.id.imageViewBack)
    ImageView imageViewBack;
    @BindView(R.id.textViewTitle)
    TextView textViewTitle;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enquiry);
        ButterKnife.bind(this);
        initialization();
        setListeners();

    }

    private void setListeners() {
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validateEmail()) {
                    return;
                }
                if (!validateName()) {
                    return;
                }
                if (!Utility.isConnected()) {
                    Utility.showToast(R.string.internet_connection);
                } else {
                    submitEnquiry(name, email, phoneno, company, address, city, state, country, details);
                }
            }
        });

        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initialization() {
        inputName.addTextChangedListener(new MyTextWatcher(inputName));
        inputEmail.addTextChangedListener(new MyTextWatcher(inputEmail));
        textViewTitle.setText("Enquiry");
        phoneno = inputPassword.getText().toString();
        company = inputCompany.getText().toString();
        address = inputAddress.getText().toString();
        city = inputCity.getText().toString();
        state = inputState.getText().toString();
        country = inputCountry.getText().toString();
        details = inputDetails.getText().toString();

    }

    private boolean validateName() {
        if (inputName.getText().toString().trim().isEmpty()) {
            inputLayoutName.setError(getString(R.string.err_msg_name));
            requestFocus(inputName);
            return false;
        } else {
            inputLayoutName.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateEmail() {
        String email = inputEmail.getText().toString().trim();
        if (email.isEmpty() || !isValidEmail(email)) {
            inputLayoutEmail.setError(getString(R.string.err_msg_email));
            requestFocus(inputEmail);
            return false;
        } else {
            inputLayoutEmail.setErrorEnabled(false);
        }

        return true;
    }

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.input_name:
                    validateName();
                    break;
                case R.id.input_email:
                    validateEmail();
                    break;

            }
        }
    }


    //for login response
    public void submitEnquiry(String name, String email, String mobile, String company, String address, String city, String state, String country, String details) {
        showProgress();
        EnquiryRequest authenticateRequest = new EnquiryRequest();
        authenticateRequest.setEmail(email);
        authenticateRequest.setName(name);
        authenticateRequest.setMobile(mobile);
        authenticateRequest.setCompany(company);
        authenticateRequest.setAddress(address);
        authenticateRequest.setCity(city);
        authenticateRequest.setState(state);
        authenticateRequest.setCountry(country);
        authenticateRequest.setDetails(details);

        EnquiryService loginService = new EnquiryService();

        loginService.executeService(authenticateRequest, new BaseApiCallback<EnquiryResponse>() {
            @Override
            public void onComplete() {
                dismissProgress();
            }

            @Override
            public void onSuccess(@NonNull EnquiryResponse response) {
                super.onSuccess(response);
                Utility.showToast(response.getData());
                Intent intent = new Intent(mContext, MainActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onFailure(APIException e) {
                super.onFailure(e);
                Utility.showToast(e.getData());

            }
        });


    }


}
