package com.example.videoviewerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    Button click;
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView= findViewById(R.id.videoview);
        videoView.setVideoPath("android.resource://"
                +getPackageName()+"/"+R.raw.video1);
        MediaController mediaController= new MediaController(this);
        mediaController.setAnchorView((videoView));
        videoView.setMediaController(mediaController);



        click=findViewById(R.id.HandOutButton);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewpdf();
            }
        });
    }

    private void viewpdf() {
        // add the link of pdf
        String value="https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf";
        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(value));

        // start activity
        startActivity(intent);
    }
}