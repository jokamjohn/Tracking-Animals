package johnkagga.me.alex_farm;

import com.firebase.client.Firebase;

public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}

