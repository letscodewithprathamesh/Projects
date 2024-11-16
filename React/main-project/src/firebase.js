// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries
import { getAuth, onAuthStateChanged } from "firebase/auth"

import firebase from "firebase/compat/app";
import store from "./Redux/store";
import { setUser,signOut } from "./Redux/store";
// Your web app's Firebase configuration
const firebaseConfig = {
  apiKey: "AIzaSyB55o6d4FUzGHd8-s66CwFe9SpAKzfP_kM",
  authDomain: "e-commerce-f3f22.firebaseapp.com",
  projectId: "e-commerce-f3f22",
  storageBucket: "e-commerce-f3f22.appspot.com",
  messagingSenderId: "49910621340",
  appId: "1:49910621340:web:76678a214e8a7f1c037959"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);

export const auth = getAuth(app)
onAuthStateChanged(auth,(user) =>
{
    if (user)
    {
        store.dispatch(setUser({
            email: user.email,
            password:user.password,
            
     }))   
    }
    else
    {
     store.dispatch(signOut())   
    }
})