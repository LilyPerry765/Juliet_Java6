/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE78_OS_Command_Injection__getQueryStringServlet_12.java
Label Definition File: CWE78_OS_Command_Injection.label.xml
Template File: sources-sink-12.tmpl.java
*/
/*
* @description
* CWE: 78 OS Command Injection
* BadSource: getQueryStringServlet Parse id param out of the querystring without getParam
* GoodSource: A hardcoded string
* BadSink: exec dynamic command execution with Runtime.getRuntime().exec()
* Flow Variant: 12 Control flow: if(IO.static_returns_t_or_f())
*
* */

package testcases.CWE78_OS_Command_Injection;

import testcasesupport.*;

import javax.servlet.http.*;

import javax.servlet.http.*;
import java.util.StringTokenizer;
import java.sql.*;
import java.io.IOException;

import java.util.logging.Logger;

public class CWE78_OS_Command_Injection__getQueryStringServlet_12 extends AbstractTestCaseServlet
{

    /* uses badsource and badsink - see how tools report flaws that don't always occur */
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if(IO.static_returns_t_or_f())
        {
            Logger log_bad = Logger.getLogger("local-logger");
            data = "";
            /* parse the query string for value of 'id' */
            String id_str = null;
            StringTokenizer st = new StringTokenizer(request.getQueryString(), "&");
            while (st.hasMoreTokens())
            {
                String token = st.nextToken();
                int i = token.indexOf("=");
                if ((i > 0) && (i < (token.length() - 1)) && (token.substring(0, i).equals("id")))
                {
                    id_str = token.substring(i + 1);
                    break;
                }
            }
            if (id_str != null)
            {
                Connection conn = null;
                PreparedStatement statement = null;
                ResultSet rs = null;
                try
                {
                    int id = Integer.parseInt(id_str);
                    conn = IO.getDBConnection();
                    statement = conn.prepareStatement("select * from pages where id=?");
                    /* FLAW: no check to see whether the user has privileges to view the data */
                    statement.setInt(1, id);
                    rs = statement.executeQuery();
                    data = rs.toString();
                }
                catch( SQLException se )
                {
                    log_bad.warning("Error");
                }
                finally
                {
                    /* clean up database objects */
                    try {
                        if( rs != null )
                        {
                            rs.close();
                        }
                    }
                    catch( SQLException se )
                    {
                        log_bad.warning("Error closing rs");
                    }
                    finally {
                        try {
                            if( statement != null )
                            {
                                statement.close();
                            }
                        }
                        catch( SQLException se )
                        {
                            log_bad.warning("Error closing statement");
                        }
                        finally {
                            try {
                                if( conn != null )
                                {
                                    conn.close();
                                }
                            }
                            catch( SQLException se)
                            {
                                log_bad.warning("Error closing conn");
                            }
                        }
                    }
                }
            }
        }
        else {

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded string */
            data = "foo";

        }

        String osCommand;
        if(System.getProperty("os.name").toLowerCase().indexOf("win") >= 0)
        {
            /* running on Windows */
            osCommand = "c:\\WINDOWS\\SYSTEM32\\cmd.exe /c dir ";
        }
        else
        {
            /* running on non-Windows */
            osCommand = "/bin/ls ";
        }

        /* POTENTIAL FLAW: command injection */
        Process p = Runtime.getRuntime().exec(osCommand + data);
        p.waitFor();

    }

    /* goodG2B() - use goodsource and badsink by changing the "if" so that
       both branches use the GoodSource */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if(IO.static_returns_t_or_f())
        {
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded string */
            data = "foo";
        }
        else {

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded string */
            data = "foo";

        }

        String osCommand;
        if(System.getProperty("os.name").toLowerCase().indexOf("win") >= 0)
        {
            /* running on Windows */
            osCommand = "c:\\WINDOWS\\SYSTEM32\\cmd.exe /c dir ";
        }
        else
        {
            /* running on non-Windows */
            osCommand = "/bin/ls ";
        }

        /* POTENTIAL FLAW: command injection */
        Process p = Runtime.getRuntime().exec(osCommand + data);
        p.waitFor();

    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
    }

    /* Below is the main(). It is only used when building this testcase on
       its own for testing or for building a binary to use in testing binary
       analysis tools. It is not used when compiling all the testcases as one
       application, which is how source code analysis tools are tested. */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}
