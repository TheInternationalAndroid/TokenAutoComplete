package com.tokenautocomplete;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

public class TokenActivity extends Activity implements TokenCompleteTextView.TokenListener<InputModel> {
    ContactsCompletionView completionView;
    InputModel[] people;
    ArrayAdapter<InputModel> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        people = new InputModel[]{
                new InputModel("Marshall Weir", "marshall"),
                new InputModel("Margaret Smith", "margaret"),
                new InputModel("Max Jordan", "max"),
                new InputModel("Meg Peterson", "meg"),
                new InputModel("Amanda Johnson", "amanda"),
                new InputModel("Terry Anderson", "terry"),
                new InputModel("Siniša Damianos Pilirani Karoline Slootmaekers",
                        "siniša_damianos_pilirani_karoline_slootmaekers")
        };

        adapter = new FilteredArrayAdapter<InputModel>(this, R.layout.person_layout, people) {
            @Override
            public View getView(int position, View convertView, @NonNull ViewGroup parent) {
                if (convertView == null) {

                    LayoutInflater l = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
                    convertView = l.inflate(R.layout.person_layout, parent, false);
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

        completionView = (ContactsCompletionView) findViewById(R.id.searchView);
        completionView.setAdapter(adapter);
        completionView.setTokenListener(this);
        completionView.setTokenClickStyle(TokenCompleteTextView.TokenClickStyle.Select);


        if (savedInstanceState == null) {
//            completionView.addObject(people[0]);
//            completionView.addObject(people[1]);
        }

        Button removeButton = (Button) findViewById(R.id.removeButton);
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<InputModel> people = completionView.getObjects();
                if (people.size() > 0) {
                    completionView.removeObject(people.get(people.size() - 1));
                }
            }
        });

        Button addButton = (Button) findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rand = new Random();
                completionView.addObject(people[rand.nextInt(people.length)]);
            }
        });
    }

    private void updateTokenConfirmation() {
        StringBuilder sb = new StringBuilder("Current tokens:\n");
        for (Object token : completionView.getObjects()) {
            sb.append(token.toString());
            sb.append("\n");
        }

        ((TextView) findViewById(R.id.tokens)).setText(sb);
    }


    @Override
    public void onTokenAdded(InputModel token) {
        ((TextView) findViewById(R.id.lastEvent)).setText("Added: " + token);
        updateTokenConfirmation();
    }

    @Override
    public void onTokenRemoved(InputModel token) {
        ((TextView) findViewById(R.id.lastEvent)).setText("Removed: " + token);
        updateTokenConfirmation();
    }
}
