package com.example.fbuinsta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.parse.ParseFile;
import com.parse.ParseImageView;

public class PostDetailActivity extends AppCompatActivity {
    TextView tvName;
    TextView tvDescription;
    TextView tvDate;
    ParseImageView ivProfile;
    ParseImageView ivPostImage;

    ParseFile photo;
    String photoUrl;
    String username;
    String description;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);

        //
        // photoUrl = (ParseFile) Parcels.unwrap(getIntent().getParcelableExtra("image"));

        photoUrl = getIntent().getExtras().getString("image");
        username = getIntent().getExtras().getString("username");
        description = getIntent().getExtras().getString("description");
        date = "Created on: " + getIntent().getExtras().getString("date");


        tvName = (TextView) findViewById(R.id.tvName);
        tvDate = (TextView) findViewById(R.id.tvDate);
        tvDescription = (TextView) findViewById(R.id.tvDescription);
        ivProfile = (ParseImageView) findViewById(R.id.ivProfile);
        ivPostImage = (ParseImageView) findViewById(R.id.ivPostImage);

        Glide.with(this).load(photoUrl).into(ivPostImage);

        //ivPostImage.setParseFile(photo);

        Glide.with(this)
                .load(R.drawable.profileimage)
                //.bitmapTransform(new RoundedCornersTransformation(this, 25, 0))
                .apply(RequestOptions.circleCropTransform())
                .into(ivProfile);

        tvName.setText(username);
        tvDescription.setText(description);
        tvDate.setText(date);


    }
}
