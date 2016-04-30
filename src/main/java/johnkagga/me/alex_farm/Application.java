package johnkagga.me.alex_farm;

import com.firebase.client.Firebase;

/**
 * Created by jokamjohn on 4/30/2016.
 */
public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}

