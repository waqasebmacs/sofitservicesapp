package com.buzzware.sofitapplication.Activity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import com.buzzware.sofitapplication.R;
public class Splash extends AppCompatActivity {
    private int STORAGE_PERMISSION_CODE = 1;
    public static final int RequestPermissionCode = 1;
    // Animation
    Animation animFadeblink;
    TextView nameTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
       //   splashHandler();
    }
    private void animation() {
        nameTV=findViewById(R.id.nameTv);
        animFadeblink = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.blink);
        nameTV.startAnimation(animFadeblink);

    }
    public void splashHandler()
    {
        if (ContextCompat.checkSelfPermission(Splash.this,
                Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            splashView();
        } else {
            requestStoragePermission();
        }
    }
    private void splashView() {
        animation();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Splash.this, BaseActivity.class));
                finish();
            }
        }, 3000);
    }
    public void enableRuntimePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(Splash.this,
                Manifest.permission.CAMERA)) {
            Toast.makeText(getApplicationContext(), "CAMERA permission allows us to Access CAMERA app", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(Splash.this, new String[]{
                    Manifest.permission.CAMERA}, RequestPermissionCode);
        }
    }
    private void requestStoragePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)) {
            new AlertDialog.Builder(this)
                    .setTitle("Permission needed!!")
                    .setMessage("This permission is needed because of Storage Access!!")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(Splash.this,
                                    new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE); }})
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == STORAGE_PERMISSION_CODE)  {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                splashView();
            } else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
                splashView();
            }
        }
    }
}