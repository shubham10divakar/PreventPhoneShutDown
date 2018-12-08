package subhamdivakar.sd.etc.preventphoneshutdown;


import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        checkCredentials();

    }
    private static final int CREDENTIALS_RESULT = 4342; //just make sure it's unique within your activity.

//    void checkCredentials() {
//        KeyguardManager keyguardManager = (KeyguardManager) this.getSystemService(Context.KEYGUARD_SERVICE);
//        try
//        {
//            if(keyguardManager.isDeviceLocked ())
//            {
//                Intent credentialsIntent = keyguardManager.createConfirmDeviceCredentialIntent("Password required", "please enter your pattern to receive your token");
//                if (credentialsIntent != null) {
//                    startActivityForResult(credentialsIntent, CREDENTIALS_RESULT);
//                } else {
//                    //no password needed
//                    Toast.makeText(this, "Please create a passowrd for device", Toast.LENGTH_SHORT).show();
//                }
//            }
//        }catch (NullPointerException e)
//        {
//            Toast.makeText(this, "Please create a passowrd for device", Toast.LENGTH_SHORT).show();
//        }
////        Intent credentialsIntent = keyguardManager.createConfirmDeviceCredentialIntent("Password required", "please enter your pattern to receive your token");
////        if (credentialsIntent != null) {
////            startActivityForResult(credentialsIntent, CREDENTIALS_RESULT);
////        } else {
////            //no password needed
////            Toast.makeText(this, "dffg", Toast.LENGTH_SHORT).show();
////        }
//
//    }


    void checkCredentials() {
        KeyguardManager keyguardManager = (KeyguardManager) this.getSystemService(Context.KEYGUARD_SERVICE);
            
                Intent credentialsIntent = keyguardManager.createConfirmDeviceCredentialIntent("Password required", "please enter your pattern to receive your token");
                if (credentialsIntent != null) {
                    startActivityForResult(credentialsIntent, CREDENTIALS_RESULT);
                } else {
                    //no password needed
                    Toast.makeText(this, "Please create a passowrd for device", Toast.LENGTH_SHORT).show();
                }


    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK && requestCode==CREDENTIALS_RESULT)
        {
            Toast.makeText(this, "Success: Verified user's identity", Toast.LENGTH_SHORT).show();

        }
//        else if(resultCode == RESULT_CANCELED && requestCode == CREDENTIALS_RESULT)
//        {
//            finish();
//            Intent obj=new Intent(this,MainActivity.class);
//            startActivity(obj);
//        }
        else if(resultCode == RESULT_CANCELED && requestCode == CREDENTIALS_RESULT)
        {
            finish();
            Intent obj=new Intent(this,MainActivity.class);
            startActivity(obj);
        }
        else
        {
            Toast.makeText(this, "Failure: Unable to verify user's identity", Toast.LENGTH_SHORT).show();

        }
    }


}
