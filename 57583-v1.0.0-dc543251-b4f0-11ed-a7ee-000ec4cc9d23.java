/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE690_NULL_Deref_from_Return__Class_String_02.java
Label Definition File: CWE690_NULL_Deref_from_Return__Class.label.xml
Template File: sources-sinks-02.tmpl.java
*/
/*
* @description
* CWE: 690 Unchecked return value is null, leading to a null pointer dereference.
* BadSource:  Use a custom method which may return null
* GoodSource: Use a custom method that never returns null
* Sinks: trim
*    GoodSink: Check data for null before calling trim()
*    BadSink : Call trim() on possibly null object
* Flow Variant: 02 Control flow: if(true) and if(false)
*
* */

package testcases.CWE690_NULL_Deref_from_Return;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

public class CWE690_NULL_Deref_from_Return__Class_String_02 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(true)
        {
            /* POTENTIAL FLAW: Call getStringG(), which may return null */
            data = CWE690_NULL_Deref_from_Return__Class__Helper.getStringBad();
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: call getStringG(), which will never return null */
            data = CWE690_NULL_Deref_from_Return__Class__Helper.getStringGood();

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(true)
        {
            /* POTENTIAL FLAW: data could be null */
            String sOut = data.trim();
            IO.writeLine(sOut);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: explicit check for null */
            if (data != null)
            {
                String sOut = data.trim();
                IO.writeLine(sOut);
            }

        }

    }

    /* goodG2B1() - use goodsource and badsink by changing first true to false */
    private void goodG2B1() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(false)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* POTENTIAL FLAW: Call getStringG(), which may return null */
            data = CWE690_NULL_Deref_from_Return__Class__Helper.getStringBad();
        }
        else {

            /* FIX: call getStringG(), which will never return null */
            data = CWE690_NULL_Deref_from_Return__Class__Helper.getStringGood();

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(true)
        {
            /* POTENTIAL FLAW: data could be null */
            String sOut = data.trim();
            IO.writeLine(sOut);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: explicit check for null */
            if (data != null)
            {
                String sOut = data.trim();
                IO.writeLine(sOut);
            }

        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(true)
        {
            /* FIX: call getStringG(), which will never return null */
            data = CWE690_NULL_Deref_from_Return__Class__Helper.getStringGood();
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* POTENTIAL FLAW: Call getStringG(), which may return null */
            data = CWE690_NULL_Deref_from_Return__Class__Helper.getStringBad();

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(true)
        {
            /* POTENTIAL FLAW: data could be null */
            String sOut = data.trim();
            IO.writeLine(sOut);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: explicit check for null */
            if (data != null)
            {
                String sOut = data.trim();
                IO.writeLine(sOut);
            }

        }
    }

    /* goodB2G1() - use badsource and goodsink by changing second true to false */
    private void goodB2G1() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(true)
        {
            /* POTENTIAL FLAW: Call getStringG(), which may return null */
            data = CWE690_NULL_Deref_from_Return__Class__Helper.getStringBad();
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: call getStringG(), which will never return null */
            data = CWE690_NULL_Deref_from_Return__Class__Helper.getStringGood();

        }
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(false)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* POTENTIAL FLAW: data could be null */
            String sOut = data.trim();
            IO.writeLine(sOut);
        }
        else {

            /* FIX: explicit check for null */
            if (data != null)
            {
                String sOut = data.trim();
                IO.writeLine(sOut);
            }

        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing statements in second if  */
    private void goodB2G2() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(true)
        {
            /* POTENTIAL FLAW: Call getStringG(), which may return null */
            data = CWE690_NULL_Deref_from_Return__Class__Helper.getStringBad();
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: call getStringG(), which will never return null */
            data = CWE690_NULL_Deref_from_Return__Class__Helper.getStringGood();

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(true)
        {
            /* FIX: explicit check for null */
            if (data != null)
            {
                String sOut = data.trim();
                IO.writeLine(sOut);
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* POTENTIAL FLAW: data could be null */
            String sOut = data.trim();

            IO.writeLine(sOut);

        }
    }

    public void good() throws Throwable
    {
        goodG2B1();
        goodG2B2();
        goodB2G1();
        goodB2G2();
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
