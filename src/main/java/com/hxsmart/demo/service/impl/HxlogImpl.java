package com.hxsmart.demo.service.impl;
import com.hxsmart.demo.service.Hxlog;
import org.apache.log4j.Logger;

import java.util.logging.Level;

public class HxlogImpl implements Hxlog {
    private static Logger log4jErrLog = null;
    private static Logger log4jNormalLog = null;
    private static Logger log4jDeployLog = null;
    private static Logger log4jWSErrLog = null;

    public static void initializeLog4j() throws Exception {

        log4jErrLog = Logger.getLogger("errorLog");
        log4jNormalLog = Logger.getLogger("normalLog");
        log4jDeployLog = Logger.getLogger("deployLog");
        log4jWSErrLog = Logger.getLogger("errorLog");

    }

    public void LogInfo(String logMsg) {
        HxlogImpl.NormalLog(logMsg);
    }

    /**
     * 错误日志记录
     *
     * @param logMsg 错误信息
     */
    public void ErrorLogInfo(String logMsg) {
        HxlogImpl.ErrorLog(logMsg);
    }

    /**
     * 错误日志记录
     *
     * @param strExecute string参数
     * @param exception 异常信息
     */
    public static void ErrorLogInfo(String strExecute, Exception exception) {
        StringBuffer sbLog = new StringBuffer();
        sbLog.append("strParam:").append(strExecute);
        if (exception != null) {
            StackTraceElement[] trace = exception.getStackTrace();
            for (StackTraceElement tempTrace : trace) {
                sbLog.append("\r\n").append(tempTrace);
            }
        }
        HxlogImpl.ErrorLog(sbLog.toString());
        sbLog.delete(0, sbLog.length());
        sbLog = null;
    }

    /**
     * websocket 错误日志
     *
     * @param logMsg
     */
    public static void wsErrorLogInfo(String logMsg) {
        HxlogImpl.WSErrorLog(logMsg);
    }

    /**
     * websocket 错误日志
     *
     * @param logMsg
     * @param exception
     */
    public static void wsErrorLogInfo(String logMsg, Exception exception) {
        StringBuffer sbLog = new StringBuffer();
        sbLog.append("errorMessage:").append(logMsg);
        if (exception != null) {
            StackTraceElement[] trace = exception.getStackTrace();
            for (StackTraceElement tempTrace : trace) {
                sbLog.append("\r\n").append(tempTrace);
            }
        }
        wsErrorLogInfo(sbLog.toString());
        sbLog.delete(0, sbLog.length());
        sbLog = null;
    }

    private static void SetUpLogInfo(String logMsg) {
        HxlogImpl.DeployLog(logMsg);
    }

    private static void WSErrorLog(String logMsg)  {
        if (null == log4jWSErrLog) {
            try {
                initializeLog4j();
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(HxlogImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        log4jWSErrLog.error(logMsg);
    }

    private static void ErrorLog(String logMsg)  {
        if (null == log4jErrLog) {
            try {
                initializeLog4j();
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(HxlogImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        log4jErrLog.error(logMsg);
    }

    private static void NormalLog(String logMsg) {
        if (null == log4jNormalLog) {
            try {
                initializeLog4j();
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(HxlogImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        log4jNormalLog.info(logMsg);
    }

    private static void DeployLog(String logMsg)  {
        if (null == log4jDeployLog) {
            try {
                initializeLog4j();
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(HxlogImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        log4jDeployLog.info(logMsg);
    }
}
