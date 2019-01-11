package com.lixinxinlove.pay.activity

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.view.View
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.alipay.sdk.app.EnvUtils
import com.alipay.sdk.app.PayTask
import com.lixinxinlove.base.activity.BaseActivity
import com.lixinxinlove.pay.R
import com.lixinxinlove.pay.util.OrderInfoUtil2_0
import com.lixinxinlove.pay.util.PayResult


/**
 * 支付
 */

@Route(path = "/pay/item")
class PayActivity : BaseActivity() {

    /**
     * 用于支付宝支付业务的入参 app_id。
     */
    val APPID = "2016082000296688"

    /**
     * 用于支付宝账户登录授权业务的入参 pid。
     */
    val PID = "2088802755295492"

    /**
     * 用于支付宝账户登录授权业务的入参 target_id。
     */
    val TARGET_ID = ""


    val RSA2_PRIVATE =
        "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCWIddt5mrwxmCZLxEMUlFniH2TK9S6HESOWVRap/CDYT5DqCSEtYp2znvS66Jy6zqHX6OSZIwEpECOjnyaExMMxoBtcH3678EjVIChN5vQEX4B3AwlVMFSvy8o1To4dLVJmF64URMl5UwJTNwirGc1GRNVx5+Ax09nCPjvVmHGW8wuDnUYWHMU7HpPlkfNzFzZrUypw66NfMcLpUCNqJlsJ1AarRBjiPVFKNmGi/xX0XFDEHKuRqSlNVCKye2kCTkPEF9H6feX+Ra+sAhRDjTEt58nzQey2H6C9GB0x/ySZcL7FH6lKWB19AEMABygxEsjaNHO1SOvCgU2Q1dJm7DJAgMBAAECggEAenUAE1RuxhYJlOkfLr22SIy8YN7PlT6ZbMLQW2HAfGlFMEpl/xlU57NkrJYm2zWjd+g6s53v15liTuVKHSKR10nSV3H6UERfdUHn6ZhCL2UVMs8Z2RlY1vW6scO6yXHorS7rk8wNokt1yeA3btDRHi5l5wH8yD3KNnDLG+2JsxDNjW20mImvyHMSgjftHy/H7LUnkHqLcor1xtn6hNEliGj6xwtGxz3JtEBOeqShwvUkSk1jUAx3B779nCh6+1t4hPkf5ln7tqh6+POHUaXol3H2AX9qTP9c0eddp7OkIwBpYuheXe77grjiWuTi1CAoKugPaXn1MLo1IDiVvR/5AQKBgQDHXuDoLeDGWNaX/fV1et6dnEbQ/ehmfqQL9qYEmI25TjL6Nc5cZT68DuM3UZ70T8p3JEB/fiz45S5h712dIjdqnS27bSFp1eiGA5ifkpu4/Ghac08S4wxs2FVnzKfEcIXlJBkBybIfZNHzCOUyKNRxMIyJ+dS0Y8vdq18N+PjQFQKBgQDAxp5oViHQ969itwcxr7wjLI6dDWN2H3F6jl7HCQxEcsi4qXUgQCodFNDsLEClJn2OUDoCN+q+RdwmfTREsEydoiaBYF4wqDjwMnp7ffF6CGSomxqEzhCtSIXDozc58IHKNUw+ObnLhJWAn4lD2GRWVSrsfTj9TZ76l1DVbrjW5QKBgBa+71/t5AgdGJaMpdV6aC2JJ9cuMLaI2kR3Jme90+WBU3WSb/HAp1CjTi8Ag+cRt2KyYx1oks7ursUDnyWPQs1KE26fu8EsY3Pusxn5iwSm32z6XNolx0QfxlaqVbWmtM/4t1Wp4kWMphtZN3TqjZpAVLhlJWxTOm4W4Chi8FglAoGAV+W4MKalQJzO0VnW4+bXB8q3NBD4utFXcqQbvvD3MPaNYvWRPCVFjoEBSc5bo3HLaepWqNBKLnu4B6yq+m7QYEeg+vivucvaOlsp0cj5I8VT8DTYgJlcrUYWB8AR3E83PrXSj8TOXGeVq1ISymaOSXcH3VCzfXu481WvO8ICcakCgYAYeNlCD1+8TqvWd+CW1DzTam0IlHds9f9u3oukFmT+MbeGI+1djIZCc4x8bXmdvpFId1XNWMj9gSZPrG/e0FLjKxUV853Nz6T2b4h7+Ggz7wNUUmn+gsu6aP7FkWYoWJIddSTLWAAF9txV9OxGQ4S4zV3WVFwYoUO6mO4Ft9ijNw=="

    var mHandler: Handler = Handler {
        when (it.what) {
            SDK_PAY_FLAG -> {
                val payResult = PayResult(it.obj as Map<String, String>)
                /**
                 * 对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                 */
                val resultInfo = payResult.getResult()// 同步返回需要验证的信息
                val resultStatus = payResult.getResultStatus()
                // 判断resultStatus 为9000则代表支付成功
                if (resultStatus == "9000") {
                    // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                    showAlert(this@PayActivity, "ppp" + payResult)
                } else {
                    // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                    showAlert(this@PayActivity, "lll" + payResult)
                }
                return@Handler true
            }
        }
        false
    }


    private val SDK_PAY_FLAG = 1
    private val SDK_AUTH_FLAG = 2


    override fun layoutId(): Int {
        return R.layout.activity_pay
    }

    override fun listener() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        EnvUtils.setEnv(EnvUtils.EnvEnum.SANDBOX)
        super.onCreate(savedInstanceState)
    }

    public fun authV2(view: View) {

    }

    public fun pay(view: View) {

        val params = OrderInfoUtil2_0.buildOrderParamMap(APPID, true)
        val orderParam = OrderInfoUtil2_0.buildOrderParam(params)
        val privateKey = RSA2_PRIVATE

        val sign = OrderInfoUtil2_0.getSign(params, privateKey, true)

        val orderInfo = "$orderParam&$sign"

        var payRunnable = Runnable {
            val alipay = PayTask(this@PayActivity)
            val result = alipay.payV2(orderInfo, true)
            Log.i("msp", result.toString())

            var msg = Message()
            msg.what = SDK_PAY_FLAG
            msg.obj = result
            mHandler.sendMessage(msg)
        }

        // 必须异步调用
        val payThread = Thread(payRunnable)
        payThread.start()

    }


    fun showAlert(ctx: Context, info: String) {
        showAlert(ctx, info, null)
    }

    fun showAlert(ctx: Context, info: String, onDismiss: DialogInterface.OnDismissListener?) {
        AlertDialog.Builder(ctx)
            .setMessage(info)
            .setPositiveButton("lll", null)
            .setOnDismissListener(onDismiss)
            .show()
    }

    fun showToast(ctx: Context, msg: String) {
        Toast.makeText(ctx, msg, Toast.LENGTH_LONG).show()
    }

}
