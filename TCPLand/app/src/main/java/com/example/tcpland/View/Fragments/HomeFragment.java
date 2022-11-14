package com.example.tcpland.View.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tcpland.Model.ItemModel;
import com.example.tcpland.R;
import com.example.tcpland.View.DashBoardAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    GridView dashboard;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AlgorithmFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.home_fragment, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dashboard = (GridView) getView().findViewById(R.id.grid_container);
        ArrayList<ItemModel> dashBoardGridItemList = new ArrayList<>();
    //todo change follow app require
        InitDashBoard(dashBoardGridItemList);
        dashboard.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                Fragment nextFrag=  dashBoardGridItemList.get(position).getTargetFragment();
                if (savedInstanceState == null)
                    getActivity().getSupportFragmentManager().beginTransaction()
                           .replace(R.id.fragment_container,nextFrag, "findThisFragment")
                           .addToBackStack(null)
                           .commit();
            }
        });
    }

    private void InitDashBoard(ArrayList<ItemModel> dashBoardGridItemList) {
        dashBoardGridItemList.add(new ItemModel("Quỹ đất Toàn Cầu Land", R.drawable.ic_fun_tcl,new Tcp_land_fund()));
        dashBoardGridItemList.add(new ItemModel("BĐS của tôi", R.drawable.ic_my_real_estate,new My_real_estate()));
        dashBoardGridItemList.add(new ItemModel("Hợp đồng hợp tác", R.drawable.ic_contract,new Contract()));
        dashBoardGridItemList.add(new ItemModel("Chuyên gia", R.drawable.ic_consultants,new Consultants()));
        dashBoardGridItemList.add(new ItemModel("Tin tức", R.drawable.ic_news,new News()));
        dashBoardGridItemList.add(new ItemModel("Câu hỏi thường gặp", R.drawable.ic_questions,new Question()));
        dashBoardGridItemList.add(new ItemModel("Mạng xã hội", R.drawable.ic_social_media,new Social_Media()));

        DashBoardAdapter adapter = new DashBoardAdapter(getActivity(), dashBoardGridItemList);
        dashboard.setAdapter(adapter);
    }
}