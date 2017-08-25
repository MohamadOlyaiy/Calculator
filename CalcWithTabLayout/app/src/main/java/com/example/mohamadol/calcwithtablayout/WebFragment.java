package com.example.mohamadol.calcwithtablayout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * A simple {@link Fragment} subclass.
 * FRAGMENT THAT DISPLAYS WEB PAGE WHEN CLICKED ON WEB TAB
 */
public class WebFragment extends Fragment {
    View view;


    public WebFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_web, container, false);

        //INITIALIZING THE WEBVIEW
        ((WebView)view.findViewById(R.id.web)).loadUrl("http://www.google.ca/search?q=wolfram+alpha&rlz=1C1CHBF_enCA733CA733&oq=wol&aqs=chrome.4.69i57j35i39j0l4.4235j0j8&sourceid=chrome&ie=UTF-8");
        WebView webview=(WebView)view.findViewById(R.id.web);
        webview.setWebViewClient(new WebViewClient(){
            @Override public boolean shouldOverrideUrlLoading(WebView v, WebResourceRequest req){
                return super.shouldOverrideUrlLoading(v,req);

            }
        });
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl("http://www.google.ca/search?q=wolfram+alpha&rlz=1C1CHBF_enCA733CA733&oq=wol&aqs=chrome.4.69i57j35i39j0l4.4235j0j8&sourceid=chrome&ie=UTF-8");
        return view;
    }

}
