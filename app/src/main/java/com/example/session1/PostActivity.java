package com.example.session1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class PostActivity extends AppCompatActivity {

    //declaring variable components to be used in this class
    private ImageView upload;
    public Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setting layout resource file for this class
        setContentView(R.layout.activity_post);

        //locating cancel button
        Button cancel = findViewById(R.id.cancelButton);
        //setting onclick listener for cancel button
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //return to previous activity
                finish();
            }
        });

        //locating submit button
        Button submit = findViewById(R.id.submitButton);

        //locating upload imageView from layout resource file
        upload = findViewById(R.id.imageView);
        //set upload onclick listener
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //instantiating intent
                Intent gallery = new Intent();
                //setting intent type to image/* to access gallery
                gallery.setType("image/*");
                //setting action to obtain image from gallery
                gallery.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(gallery, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //if the request code set above is 1, result ok and the data obtained from gallery is not null
        if(requestCode==1 && resultCode==RESULT_OK && data.getData()!= null){
            //set imageURI variable set above to the data obtained from gallery
            imageUri = data.getData();
            //upload imageView is set to the image selected from gallery
            upload.setImageURI(imageUri);
        }
    }
}
