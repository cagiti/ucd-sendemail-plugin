/**
 * � Copyright IBM Corporation 2014.  
 * This is licensed under the following license.
 * The Eclipse Public 1.0 License (http://www.eclipse.org/legal/epl-v10.html)
 * U.S. Government Users Restricted Rights:  Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp. 
 */

package com.urbancode.air

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.ManagerFactoryParameters;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactorySpi;

public class XTrustManagerFactory extends TrustManagerFactorySpi {

    //**********************************************************************************************
    // CLASS
    //**********************************************************************************************

    //**********************************************************************************************
    // INSTANCE
    //**********************************************************************************************

    //------------------------------------------------------------------------------------------
    public XTrustManagerFactory() {
    }

    //------------------------------------------------------------------------------------------
    @Override
    protected void engineInit(KeyStore keystore) {
    }

    //------------------------------------------------------------------------------------------
    @Override
    protected void engineInit(ManagerFactoryParameters managerParams)
    throws InvalidAlgorithmParameterException {
        throw new InvalidAlgorithmParameterException(
                "XTrustManagerFactory cannot be initialized using ManagerFactoryParameters");
    }

    //------------------------------------------------------------------------------------------
    @Override
    protected TrustManager[] engineGetTrustManagers() {
        List<TrustManager> managerList = new ArrayList<TrustManager>();
        managerList.add(new OpenX509TrustManager());

        return managerList.toArray(new TrustManager[managerList.size()]);
    }
}
