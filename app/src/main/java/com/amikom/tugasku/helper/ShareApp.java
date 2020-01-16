package com.amikom.tugasku.helper;

import android.content.Context;
import android.content.Intent;

public class ShareApp {
    public static void share(Context context) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "Aplikasi Amikom Two tersedia di Play Store, silahkan download di " +
                "https://play.google.com/store/apps/details?id=com.whatsapp");
        context.startActivity(Intent.createChooser(intent, "Bagikan dengan"));
    }

}
