package entre2.house_home.kostanku;

import android.graphics.Typeface;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.lang.reflect.Field;

/**
 * Created by Adrian Lukito Lo on 12/10/2017.
 */

public class BottomNavigationViewHelper {
    public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx){
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
    }
}
