package com.buzzware.sofitapplication.Retrofit.Dialogebox;
import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;
import com.buzzware.sofitapplication.R;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.Wave;
public class CustomProgressDialog extends Dialog {
    private static CustomProgressDialog dialog;
    Activity c;
    public static CustomProgressDialog getInstance(Activity context) {
        if (dialog == null) {
            dialog = new CustomProgressDialog(context);
        }
        return dialog;
    }
    public CustomProgressDialog(Activity context) {
        super(context, R.style.CustomProgressDialog);
        c = context;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_custom_progress);
        View view = getWindow().getDecorView();
        ProgressBar progressBar = view.findViewById(R.id.progress);
        Sprite doubleBounce = new Wave();
        progressBar.setIndeterminateDrawable(doubleBounce);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        view.setBackgroundResource(android.R.color.transparent);
    }
    public void showProgressDialog() {
        if (!c.isFinishing() && !isShowing())
            show();
    }
    public void dismissProgressDialog() {
        if (isShowing()) {
            cancel();
        }
        CustomProgressDialog.dialog = null;
    }
    public void setDialogCancellable(Boolean cancellable) {
        this.setCancelable(cancellable);
    }
}
