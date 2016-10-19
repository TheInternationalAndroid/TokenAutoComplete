package rayman.sample;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.tokenautocomplete.InputCompletionView;
import com.tokenautocomplete.InputFilterAdapter;
import com.tokenautocomplete.InputModel;
import com.tokenautocomplete.TokenCompleteTextView;

public class MainActivity extends AppCompatActivity implements InputCompletionView.InputTokenListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InputModel[] inputModels = new InputModel[]{
                new InputModel("Marshall Weir", "marshall"),
                new InputModel("Margaret Smith", "margaret"),
                new InputModel("Max Jordan", "max"),
                new InputModel("Meg Peterson", "meg"),
                new InputModel("Amanda Johnson", "amanda"),
                new InputModel("Terry Anderson", "terry"),
                new InputModel("Siniša Damianos Pilirani Karoline Slootmaekers",
                        "siniša_damianos_pilirani_karoline_slootmaekers")
        };

        ArrayAdapter<InputModel> adapter = new InputFilterAdapter(this, R.layout.list_cell_filter_layout, inputModels) {
            @Override
            public View getView(int position, View convertView, @NonNull ViewGroup parent) {
                if (convertView == null) {
                    LayoutInflater l = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
                    convertView = l.inflate(R.layout.list_cell_filter_layout, parent, false);
                }

                InputModel inputWrapper = getItem(position);
                if (inputWrapper != null) {
                    ((TextView) convertView.findViewById(R.id.name)).setText(inputWrapper.getInput());
                }
                return convertView;
            }

            @Override
            protected boolean keepObject(InputModel inputModel, String mask) {
                mask = mask.toLowerCase();
                return inputModel.getInput().toLowerCase().startsWith(mask) || inputModel.getFormattedInput().toLowerCase().startsWith(mask);
            }
        };

        InputCompletionView completionView = (InputCompletionView) findViewById(R.id.searchView);
        completionView.setAdapter(adapter);
        completionView.setTokenListener(this);
        completionView.setTokenClickStyle(TokenCompleteTextView.TokenClickStyle.Select);
    }

    @Override
    public void onTokenAdded(InputModel token) {
        Toast.makeText(this, "Added: " + token, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTokenRemoved(InputModel token) {
        Toast.makeText(this, "Removed: " + token, Toast.LENGTH_SHORT).show();
    }
}
