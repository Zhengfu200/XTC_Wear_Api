package com.example.wear_api;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String source = intent.getStringExtra("source");
        String ctime = intent.getStringExtra("ctime");
        String url = intent.getStringExtra("url");
        String description = intent.getStringExtra("description");

        TextView titleTextView = findViewById(R.id.detail_title);
        TextView sourceTextView = findViewById(R.id.detail_source);
        TextView ctimeTextView = findViewById(R.id.detail_ctime);
        TextView urlTextView = findViewById(R.id.detail_url);
        TextView descriptionTextView = findViewById(R.id.detail_description);

        titleTextView.setText(title);
        sourceTextView.setText(source);
        ctimeTextView.setText(ctime);
        urlTextView.setText(url);
        descriptionTextView.setText(description);

        urlTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(browserIntent);
            }
        });
    }
}