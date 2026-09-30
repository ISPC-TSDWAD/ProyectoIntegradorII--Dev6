package com.edutools
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
class RegisterActivity : AppCompatActivity() {
    private val api = Retrofit.Builder().baseUrl("http://10.0.2.2:8000/")
        .addConverterFactory(GsonConverterFactory.create()).build().create(ApiService::class.java)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val etUser = findViewById<EditText>(R.id.etUserReg)
        val etPass = findViewById<EditText>(R.id.etPassReg)
        val btn = findViewById<Button>(R.id.btnRegister)
        val tvMsg = findViewById<TextView>(R.id.tvMsgReg)
        btn.setOnClickListener {
            val req = LoginRequest(etUser.text.toString(), etPass.text.toString())
            api.register(req).enqueue(object: Callback<Map<String,String>>{
                override fun onResponse(call: Call<Map<String,String>>, response: Response<Map<String,String>>) {
                    if(response.isSuccessful){ tvMsg.text="Usuario creado"; finish() }
                    else { tvMsg.text="Error: ${response.errorBody()?.string()}" }
                }
                override fun onFailure(call: Call<Map<String,String>>, t: Throwable) { tvMsg.text=t.message }
            })
        }
    }
}
