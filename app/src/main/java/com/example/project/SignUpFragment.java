package com.example.project;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SignUpFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SignUpFragment extends Fragment {
    Button register;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public SignUpFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SignUpFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SignUpFragment newInstance(String param1, String param2) {
        SignUpFragment fragment = new SignUpFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        EditText firstNameInfo = getView().findViewById(R.id.firstNameField);
        EditText lastNameInfo = getView().findViewById(R.id.lastNameField);
        EditText phoneInfo = getView().findViewById(R.id.phoneField);
        EditText emailInfo = getView().findViewById(R.id.emailField);
        EditText passwordInfo = getView().findViewById(R.id.passwordField);
        EditText confirmPasswordInfo = getView().findViewById(R.id.confirmPasswordField);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstName = firstNameInfo.getText().toString();
                String lastName = lastNameInfo.getText().toString();
                String phone = phoneInfo.getText().toString();
                String email = emailInfo.getText().toString();
                String password = passwordInfo.getText().toString();
                String confirmPassword = confirmPasswordInfo.getText().toString();

                if (!firstName.isEmpty() && !lastName.isEmpty() && !phone.isEmpty() && !email.isEmpty() && !password.isEmpty() && !confirmPassword.isEmpty()
                && (password.equals(confirmPassword))) {

                }
            }
        });
        return inflater.inflate(R.layout.fragment_sign_up, container, false);
    }




}