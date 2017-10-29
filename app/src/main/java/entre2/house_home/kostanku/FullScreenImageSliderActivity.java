package entre2.house_home.kostanku;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.HashMap;

public class FullScreenImageSliderActivity extends ActionBarActivity {

    SliderLayout slider;

    //Bundle extras = getIntent().getExtras();

    //int currentPosition = extras.getInt("currentPosition");
    //int[] imageInteger = extras.getIntArray("imageInteger");
    //String[] imageName = (String[]) extras.getStringArray("imageName");

    int currentPosition = 0;
    int[] imageInteger = {R.drawable.sample_1,R.drawable.sample_2,R.drawable.sample_3,R.drawable.sample_4};
    String[] imageName = {"Sample 1","Sample 2","Sample 3","Sample 4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_image_slider);

        //Toast.makeText(this, "asd : "+ currentPosition, Toast.LENGTH_SHORT).show();

        slider = (SliderLayout) findViewById(R.id.slider);

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put(imageName[0],imageInteger[0]);
        file_maps.put(imageName[1],imageInteger[1]);
        file_maps.put(imageName[2],imageInteger[2]);
        file_maps.put(imageName[3],imageInteger[3]);

        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);

            textSliderView
                    //.description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);
                    //.setOnSliderClickListener(this);

            //textSliderView.bundle(new Bundle());
            //textSliderView.getBundle().putString("name",name);
            //textSliderView.getBundle().putString("imageInteger",name);

            slider.addSlider(textSliderView);
        }
        slider.setCurrentPosition(currentPosition);
        slider.setPresetTransformer(SliderLayout.Transformer.ZoomOut);
        slider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        slider.setCustomAnimation(new DescriptionAnimation());
    }

    @Override
    protected void onStop() {
        slider.stopAutoCycle();
        super.onStop();
    }
}
