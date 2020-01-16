package com.amikom.tugasku.helper;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class MoreApp {
    public static void more(Context context) {
        context.startActivity(new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://play.google.com/store/apps/developer?id=WhatsApp+Inc.")));
    }
}
