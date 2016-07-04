//
//  ViewController.swift
//  BVSPAnalytics
//
//  Created by Walter Junior on 04/07/16.
//  Copyright © 2016 Walter Junior. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var webView: UIWebView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        print("App Loaded Sucess")

        let url = NSURL(string: "http://localhost/#bovespa:EMPRESAS?5B504F5")
        
        webView.loadRequest(NSURLRequest(URL: url!))
        
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        
    }


}

