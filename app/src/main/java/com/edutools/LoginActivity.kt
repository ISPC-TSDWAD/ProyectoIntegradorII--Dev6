package com.edutools
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
data class LoginRequest(val username: String, val password: String)
data class LoginResponse(val access: String, val refresh: String)
interface ApiService {
    @POST("api/login/")
    fun login(@Body req: LoginRequest): Call<LoginResponse>
    @POST("api/register/")
    fun register(@Body req: LoginRequest): Call<Map<String,String>>
}
class LoginActivity : AppCompatActivity() {
    private val api = Retrofit.Builder().baseUrl("http://10.0.2.2:8000/")
        .addConverterFactory(GsonConverterFactory.create()).build().create(ApiService::class.java)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val etUser = findViewById<EditText>(R.id.etUser)
        val etPass = findViewById<EditText>(R.id.etPass)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnGoRegister = findViewById<Button>(R.id.btnGoRegister)
        val tvMsg = findViewById<TextView>(R.id.tvMsg)
        btnLogin.setOnClickListener {
            val req = LoginRequest(etUser.text.toString(), etPass.text.toString())
            api.login(req).enqueue(object: Callback<LoginResponse>{
                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    if(response.isSuccessful){
                        getSharedPreferences("edutools", MODE_PRIVATE).edit().putString("token", response.body()?.access).apply()
                        tvMsg.text="Login OK"
                        startActivity(Intent(this@LoginActivity, MainActivity::class.java)); finish()
                    } else { tvMsg.text="Error ${response.code()} - queda en LOG" }
                }
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) { tvMsg.text="Error: ${t.message}" }
            })
        }
        btnGoRegister.setOnClickListener { startActivity(Intent(this, RegisterActivity::class.java)) }
    }
}
