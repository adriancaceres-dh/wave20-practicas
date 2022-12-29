package com.bootcamp.be_java_hisp_w20_g4.model;


public class Seller extends User{

    private int getCountFollowers(){
        return super.getFollowers().size();
    }

    // TODO: 29/12/22
    private Publication addPublication(Publication publicationToAdd){
        if(super.getPublications().containsKey(publicationToAdd)){
            return null; // ya existe la publicacion tiene que lanzar una excepcion
        }else{
            super.getPublications().put(publicationToAdd.getPost_id(), publicationToAdd);
            return publicationToAdd;
        }
    }
}
