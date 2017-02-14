package com.proxym_it.app.structure_app.commons.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bayoudh on 25/01/2017.
 */
public class EmailUtil {
    public final static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }


    public static void sendSharingEmail(Context _Context, String subject, String body) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, body);
        emailIntent.setType("message/rfc822");
        try {
            _Context.startActivity(Intent.createChooser(emailIntent, "Sending email..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(_Context, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }

    public static void sendSharingEmailWithImages(Activity _Context, String subject, String body, ArrayList<Uri> uri) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("application/image");
        //emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{strEmail});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, body);


        emailIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, uri);


        try {
            _Context.startActivity(Intent.createChooser(emailIntent, "Sending email..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(_Context, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }


    public static void sendmailImages(Context _Context, String subject, String body, ArrayList<String> attachmentPath) {
        try {
            Intent intent = new Intent(Intent.ACTION_SEND_MULTIPLE);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            intent.putExtra(Intent.EXTRA_TEXT, body);
            intent.setType("message/rfc822");
            PackageManager pm = _Context.getPackageManager();
            List<ResolveInfo> matches = pm.queryIntentActivities(intent, 0);
            ResolveInfo best = null;
            for (final ResolveInfo info : matches) {
                if (info.activityInfo.packageName.contains(".gm.") || info.activityInfo.name.toLowerCase().contains("gmail"))
                    best = info;
            }
            ArrayList<Uri> uri = new ArrayList<Uri>();
            for (int i = 0; i < attachmentPath.size(); i++) {
                File file = new File(attachmentPath.get(i));
                uri.add(Uri.fromFile(file));
            }

            intent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, uri);


            if (best != null)
                intent.setClassName(best.activityInfo.packageName, best.activityInfo.name);

            _Context.startActivity(Intent.createChooser(intent, "Choose an email application..."));
        } catch (Exception ex) {
            ex.printStackTrace();
            Toast.makeText(_Context, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }

}
