package com.saurabh.myapplication.ui.login



import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.saurabh.myapplication.R
import com.saurabh.myapplication.databinding.ActivityLoginBinding
import com.saurabh.myapplication.ui.login.viewmodel.LoginViewModel
import com.saurabh.myapplication.util.CustomeProgressDialog


class LoginActivity : AppCompatActivity() {

    var binding: ActivityLoginBinding? = null
    var viewmodel: LoginViewModel? = null
    var customeProgressDialog: CustomeProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewmodel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        binding?.viewmodel = viewmodel
        customeProgressDialog = CustomeProgressDialog(this)
        initObservables()


    }

    private fun initObservables() {
        viewmodel?.progressDialog?.observe(this, Observer {
            if (it!!) customeProgressDialog?.show() else customeProgressDialog?.dismiss()
        })

        viewmodel?.userLogin?.observe(this, Observer { user ->
            Toast.makeText(this, "welcome, ${user?.last_name}", Toast.LENGTH_LONG).show()
        })
    }


}
