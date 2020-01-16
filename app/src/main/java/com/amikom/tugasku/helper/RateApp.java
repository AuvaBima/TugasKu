package com.amikom.tugasku.helper;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;

public class RateApp {
    public static void rate(final Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Suka dengan aplikasi ini? Rate kami di PlayStore dengan bintang 5. Terima kasih");
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                context.startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/details?id=com.whatsapp")));
            }
        });
        builder.setNegativeButton(android.R.string.cancel, null);
        builder.show();
    }
}
