package com.encle.emicalculator;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.encle.emicalculator.Adapters.BankAdapter;
import com.encle.emicalculator.Model.Bank;
import com.example.emicalculator.R;

import java.util.ArrayList;
import java.util.List;

public class Bank_Services extends AppCompatActivity {
    private RecyclerView recyclerView;
    private BankAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_services);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        // Create a list of banks
        List<Bank> bankList = createBankList();

        // Initialize and set up the adapter
        adapter = new BankAdapter(this, bankList);
        recyclerView.setAdapter(adapter);
    }

    // Method to create a list of banks
    private List<Bank> createBankList() {
        List<Bank> banks = new ArrayList<>();

        banks.add(new Bank(1, "Allahabad Bank", R.drawable.bank_allahabad, "8108781085", "9224150150", "1800-57-22-000"));
        banks.add(new Bank(2, "Andhra Bank", R.drawable.bank_andhara, "9223008586", "9223008586", "1800 425 1515"));
        banks.add(new Bank(3, "Axis Bank", R.drawable.bank_axis, "18004195959", "1800-419-6868", "1800 103 5577"));
        banks.add(new Bank(4, "Bandhan Bank", R.drawable.bank_bandhan, "9223008666", "9223008777", "1800 258 8181"));
        banks.add(new Bank(5, "Bank of Baroda", R.drawable.bank_bob, "8468001111", "8468001122", "1800 5700"));
        banks.add(new Bank(6, "Bank of India", R.drawable.bank_boi, "9266135135", "9015135135", "1800 103 1906"));
        banks.add(new Bank(7, "Bank of Maharashtra", R.drawable.bank_maharashtra, " 9222281818", "18001022636", "1800 233 4526"));
        banks.add(new Bank(8, "Barclays Bank", R.drawable.bank_barclays, "2260007888", "03457 345 3451", "0333 200 9090"));
        banks.add(new Bank(9, "Bharatiya Mahila Bank", R.drawable.bank_bmi, "9212438888", "9212438888", "9212438888"));
        banks.add(new Bank(10, "Canara Bank", R.drawable.bank_canara, "9015734734", "9015734734", "1800 1030"));
        banks.add(new Bank(11, "Corporation Bank", R.drawable.bank_corporation, "9268892688", "9268892688", "1800 425 3555"));
        banks.add(new Bank(12, "Citi Bank", R.drawable.bank_citibank, "1860-210-2484", "1860-210-2484", "1860 210 2484"));
        banks.add(new Bank(13, "Dhanalaxmi Bank", R.drawable.bank_dhanlaxmi, "8067747700", "+91-80-67747700", "044 4241 3000"));
        banks.add(new Bank(14, "Deutsche Bank", R.drawable.bank_deutsche, "18001236601", "18602666601", "1860 266 6601"));
        banks.add(new Bank(15, "Federal Bank", R.drawable.bank_federal, "8431900900", "8431600600", "1800 420 1199"));
        banks.add(new Bank(16, "HDFC Bank", R.drawable.bank_hdfc, "1800-270-3333", "1800-270-3355", "1800 210 0018"));
        banks.add(new Bank(17, "HSBC Bank", R.drawable.bank_hsbc, "18002673286", "1800 419 5400", "1860 266 2667"));
        banks.add(new Bank(18, "ICICI Bank", R.drawable.bank_icici, "18601207777", "18002003344", "1800 103 8181"));
        banks.add(new Bank(19, "IDFC Bank", R.drawable.bank_idfc, "1800-2700-720", "1800-2700-720", "044-4564 4201"));
        banks.add(new Bank(20, "SBT Bank", R.drawable.bank_sbt, "18004252244", "18004258888", "1800 425 5566"));
        banks.add(new Bank(21, "Indian Overseas Bank", R.drawable.bank_indian_overseas, "9210622122", "8424022122", "1800 425 4445"));
        banks.add(new Bank(22, "IndusInd Bank", R.drawable.bank_indusind, "18002741000", "9212299955", "1860 267 7777"));
        banks.add(new Bank(23, "Karnataka Bank", R.drawable.bank_karnataka, "18004251445", "18004251446", "1800 425 1444"));
        banks.add(new Bank(24, "Kotak Mahindra Bank", R.drawable.bank_kotak, "18002740110", "18002740110", "1860 266 2666"));
        banks.add(new Bank(25, "Citi Union Bank", R.drawable.bank_citi_union, "9278177555", "9278177444", "044 7122 5000"));
        banks.add(new Bank(26, "Panjab National Bank", R.drawable.bank_panjab, "0120-2303090", "18001802223", "1800 1800"));
        banks.add(new Bank(27, "Punjab & Sind Bank", R.drawable.bank_punjabsind, "7039035156", "7039035156", "1800 419 8300"));
        banks.add(new Bank(28, "Saraswat Bank", R.drawable.bank_saraswat, "9223040000", "9029059271", "1800 22 9999"));
        banks.add(new Bank(29, "South Indian Bank", R.drawable.bank_south_indian, "9223008488", "9223008488", "1800 425 1809"));
        banks.add(new Bank(30, "Standard Chartered Bank", R.drawable.bank_standard_c, "9987123123", "9987123123", "6601 242"));
        banks.add(new Bank(31, "State Bank of India", R.drawable.bank_sbi, "9223866666", "9223866666", "1800 1234"));
        banks.add(new Bank(32, "Syndicate Bank", R.drawable.bank_syndicate, "9015613613", "9210332255", "1800 3011 3333"));
        banks.add(new Bank(33, "UCO Bank", R.drawable.bank_uco, "1800 274 0123", "1800-274-0123", "1800 274 0123"));
        banks.add(new Bank(34, "Union Bank of India", R.drawable.bank_union, "9223008586", "9223008586", "1800 22 2244"));
        banks.add(new Bank(35, "United Together Bank", R.drawable.bank_united_together, "09015431345", "09223008586", "1800 345 0345"));
        banks.add(new Bank(36, "Vijaya Bank", R.drawable.bank_vijaya, "18004255885", "18001035535", "1800 425 9992"));


        return banks;
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void txt_back(View view) {
        finish();
    }
}