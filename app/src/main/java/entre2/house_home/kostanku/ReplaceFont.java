package entre2.house_home.kostanku;

import android.content.Context;
import android.graphics.Typeface;

import java.lang.reflect.Field;

/**
 * Created by Adrian Lukito Lo on 07/10/2017.
 */

public class ReplaceFont {

    public static void replaceDefaultFont(Context context, String nameOfFontBeingReplaced, String nameOfFontInAsset){
        Typeface customFontTypeface = Typeface.createFromAsset(context.getAssets(), nameOfFontInAsset);
        replaceFont(nameOfFontBeingReplaced, customFontTypeface);
    }

    public static void replaceFont(String nameOfFontBeingReplaced, Typeface customFontTypeface){
        try {
            Field field = Typeface.class.getDeclaredField(nameOfFontBeingReplaced);
            field.setAccessible(true);
            field.set(null, customFontTypeface);
        }catch (NoSuchFieldException e){
            e.printStackTrace();
        }catch(IllegalAccessException e){
            e.printStackTrace();
        }
    }
}
