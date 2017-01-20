/*
 * The MIT License
 *
 * Copyright 2017 Isaac Aymerich <isaac.aymerich@gmail.com>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.github.segator.proxylive;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.time.DurationFormatUtils;

/**
 *
 * @author Isaac Aymerich <isaac.aymerich@gmail.com>
 */
public class ProxyLiveUtils {

    public static String getOS() {

        String OS = System.getProperty("os.name").toLowerCase();

        if (OS.contains("win")) {
            return "win";
        } else if (OS.contains("mac")) {
            return "mac";
        } else if (OS.contains("nix") || OS.contains("nux") || OS.indexOf("aix") > 0) {
            return "unix";
        }
        return null;
    }

    public static String getServerContext(HttpServletRequest request) {
        return request.getScheme() + "://" + request.getHeader("host") + request.getContextPath();
    }

    public static String convertMilisToTime(long time) {
        return DurationFormatUtils.formatDurationWords(time, true, true);
    }

    public static String getRequestIP(HttpServletRequest request) {
        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }
        return ipAddress;
    }

    public static String getBrowserInfo(HttpServletRequest request) {
        return request.getHeader("User-Agent");
    }
}
