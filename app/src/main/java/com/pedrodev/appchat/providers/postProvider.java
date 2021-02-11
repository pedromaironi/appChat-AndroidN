package com.pedrodev.appchat.providers;

import android.view.View;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.pedrodev.appchat.models.Post;

public class postProvider {

    private CollectionReference mCollection;

    public postProvider(){
        mCollection = FirebaseFirestore.getInstance().collection("Posts");
    }

    public Task<Void> save(Post post){
        return mCollection.document().set(post);
    }


    public Query getAllPost(){
        // QUERY FROM CLIENT TO FIREBASE ALL POST DESCENDING
        return mCollection.orderBy("timestamp", Query.Direction.DESCENDING);

    }

    public Query getPostByUser(String id){
        return mCollection.whereEqualTo("idUser", id);
    }
}
