package org.techtown.capstone_final.fragment.Home;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import org.techtown.capstone_final.MakeRoomContianerActivity;
import org.techtown.capstone_final.Model.Room;
import org.techtown.capstone_final.databinding.FragmentHomeBinding;
import org.techtown.capstone_final.fragment.Home.Adapters.FragementAdapter;

import java.util.ArrayList;

public class HomeActivity extends Fragment {

    FragmentHomeBinding binding;
    ArrayList<Room> list = new ArrayList<>();
    ProgressDialog progressDialog;
    FirebaseAuth auth;
    FirebaseDatabase database;
    RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.viewPager.setAdapter(new FragementAdapter(getChildFragmentManager()));
        binding.tablayout.setupWithViewPager(binding.viewPager);


    }

    @Nullable
    @Override // oncreatview MainActivty => activy_main_xml 연동하는 느낌이라고 생각하면됩니다. 연결되게 해주는거
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable Bundle savedInstanceState)
    {

        binding = FragmentHomeBinding.inflate(inflater,container,false);

//        RoomsAdapter adapter = new RoomsAdapter(list,getContext());


        binding.basketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), MakeRoomContianerActivity.class);
                startActivity(intent);
            }
        });
        return  binding.getRoot();
    }
}
