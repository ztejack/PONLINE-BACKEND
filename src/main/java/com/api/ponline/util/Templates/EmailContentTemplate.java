package com.api.ponline.util.Templates;

import org.springframework.stereotype.Component;

@Component
public class EmailContentTemplate {

    public String getMailButton(String ponMailValTitle,String ponMailValLink,String ponMailValLabelBtn,String ponMailValBody1,String ponMailValBody2,String ponMailValBody3,String ponMailValBody4) {
        String content = 
        " <div><div><u></u><div style=\"box-sizing:border-box;font-family:-apple-system,BlinkMacSystemFont,'Segoe UI',Roboto,Helvetica,Arial,sans-serif,'Apple Color Emoji','Segoe UI Emoji','Segoe UI Symbol';background-color:#ffffff;color:#718096;height:100%;line-height:1.4;margin:0;padding:0;width:100%!important\"> " +
        " <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"box-sizing:border-box;font-family:-apple-system,BlinkMacSystemFont,'Segoe UI',Roboto,Helvetica,Arial,sans-serif,'Apple Color Emoji','Segoe UI Emoji','Segoe UI Symbol';background-color:#edf2f7;margin:0;padding:0;width:100%\"> " +
        " <tbody> <tr> <td align=\"center\" style=\"box-sizing:border-box;font-family:-apple-system,BlinkMacSystemFont,'Segoe UI',Roboto,Helvetica,Arial,sans-serif,'Apple Color Emoji','Segoe UI Emoji','Segoe UI Symbol'\"> " +
        " <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"box-sizing:border-box;font-family:-apple-system,BlinkMacSystemFont,'Segoe UI',Roboto,Helvetica,Arial,sans-serif,'Apple Color Emoji','Segoe UI Emoji','Segoe UI Symbol';margin:0;padding:0;width:100%\"> " +
        " <tbody> <tr> <td style=\"box-sizing:border-box;font-family:-apple-system,BlinkMacSystemFont,'Segoe UI',Roboto,Helvetica,Arial,sans-serif,'Apple Color Emoji','Segoe UI Emoji','Segoe UI Symbol';padding:25px 0;text-align:center\"> " +
        " <div style=\"box-sizing:border-box;font-family:-apple-system,BlinkMacSystemFont,'Segoe UI',Roboto,Helvetica,Arial,sans-serif,'Apple Color Emoji','Segoe UI Emoji','Segoe UI Symbol';color:#3d4852;font-size:19px;font-weight:bold;text-decoration:none;display:inline-block\"> " +
        " <span id=\"logo_ponline\" width=\"75px\" alt=\"PONLINE\" style=\"box-sizing:border-box;font-family:-apple-system,BlinkMacSystemFont,'Segoe UI',Roboto,Helvetica,Arial,sans-serif,'Apple Color Emoji','Segoe UI Emoji','Segoe UI Symbol';max-width:100%;border:none;height:75px;max-height:75px;width:75px\"> " +
        " <svg xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" viewBox=\"0 0 512.46 419.54\" style=\"box-sizing:border-box;font-family:-apple-system,BlinkMacSystemFont,'Segoe UI',Roboto,Helvetica,Arial,sans-serif,'Apple Color Emoji','Segoe UI Emoji','Segoe UI Symbol';max-width:100%;border:none;height:75px;max-height:75px;width:75px\"> " +
        " <defs> <style> .cls-1 { fill: #3ab4f2; } .cls-2 { fill: none; stroke: url(#linear-gradient);  } .cls-3 {  fill: #0078aa;  }  .cls-4 {  fill: url(#linear-gradient-7); " +
        " }  .cls-5 { " +
        " fill: url(#linear-gradient-8); " +
        " } " +
        " " +
        " .cls-6 { " +
        " fill: url(#linear-gradient-9); " +
        " } " +
        " " +
        " .cls-7 { " +
        " fill: url(#linear-gradient-10); " +
        " } " +
        " </style> " +
        " <linearGradient id=\"linear-gradient\" x1=\"98.55\" y1=\"292.23\" x2=\"503.91\" y2=\"292.23\" " +
        " gradientUnits=\"userSpaceOnUse\"> " +
        " <stop offset=\"0\" stop-color=\"#0078aa\" /> " +
        " <stop offset=\"0.13\" stop-color=\"#f0f7fa\" /> " +
        " <stop offset=\"0.14\" stop-color=\"#e4f1f6\" /> " +
        " <stop offset=\"0.17\" stop-color=\"#c6e1ec\" /> " +
        " <stop offset=\"0.21\" stop-color=\"#94c6db\" /> " +
        " <stop offset=\"0.26\" stop-color=\"#4fa2c4\" /> " +
        " <stop offset=\"0.3\" stop-color=\"#0078aa\" /> " +
        " <stop offset=\"0.48\" stop-color=\"#d4e8f1\" /> " +
        " <stop offset=\"0.5\" stop-color=\"#c2deeb\" /> " +
        " <stop offset=\"0.55\" stop-color=\"#93c6db\" /> " +
        " <stop offset=\"0.62\" stop-color=\"#489ec2\" /> " +
        " <stop offset=\"0.68\" stop-color=\"#0078aa\" /> " +
        " <stop offset=\"0.88\" stop-color=\"#fff\" /> " +
        " <stop offset=\"0.89\" stop-color=\"#f6fafc\" /> " +
        " <stop offset=\"0.9\" stop-color=\"#dcecf3\" /> " +
        " <stop offset=\"0.93\" stop-color=\"#b2d6e5\" /> " +
        " <stop offset=\"0.95\" stop-color=\"#79b8d2\" /> " +
        " <stop offset=\"0.98\" stop-color=\"#3091ba\" /> " +
        " <stop offset=\"1\" stop-color=\"#0078aa\" /> " +
        " </linearGradient> " +
        " <linearGradient id=\"linear-gradient-7\" x1=\"222.71\" y1=\"26.69\" x2=\"334.4\" y2=\"26.69\" " +
        " gradientUnits=\"userSpaceOnUse\"> " +
        " <stop offset=\"0\" stop-color=\"#3ab4f2\" /> " +
        " <stop offset=\"1\" stop-color=\"#0078aa\" /> " +
        " </linearGradient> " +
        " <linearGradient id=\"linear-gradient-8\" x1=\"211.27\" y1=\"7.95\" x2=\"299.01\" y2=\"7.95\" " +
        " xlink:href=\"#linear-gradient-7\" /> " +
        " <linearGradient id=\"linear-gradient-9\" x1=\"243.05\" y1=\"50.08\" x2=\"371.8\" y2=\"50.08\" " +
        " xlink:href=\"#linear-gradient-7\" /> " +
        " <linearGradient id=\"linear-gradient-10\" y1=\"214.65\" x2=\"512.46\" y2=\"214.65\" gradientUnits=\"userSpaceOnUse\"> " +
        " <stop offset=\"0\" stop-color=\"#047caf\" /> " +
        " <stop offset=\"0.49\" stop-color=\"#3ab4f2\" /> " +
        " <stop offset=\"1\" stop-color=\"#0078aa\" /> " +
        " </linearGradient> " +
        " </defs> " +
        " <title>Ponline_Svg</title> " +
        " <g id=\"Layer_2\" data-name=\"Layer 2\"> " +
        " <g id=\"Layer_1-2\" data-name=\"Layer 1\"> " +
        " <path class=\"cls-1\" " +
        " d=\"M128.27,360.62a28,28,0,0,1-10.82-2.21,28.66,28.66,0,0,1-9.57-6.54,31.94,31.94,0,0,1-6.78-10.79,40.2,40.2,0,0,1-2.55-14.86q.14-11.73,5-19.54a30.8,30.8,0,0,1,11.39-11.16,29.15,29.15,0,0,1,14.25-3.83,26,26,0,0,1,13,3.46,26.29,26.29,0,0,1,10.08,10.72q4.28,7.74,4.41,20.22a44.58,44.58,0,0,1-2.38,15.26,30.42,30.42,0,0,1-6.41,10.75,26.87,26.87,0,0,1-19.57,8.52Zm9.9-8.28q3.2,0,6.31-3.19a23.61,23.61,0,0,0,5.12-9,43,43,0,0,0,2-13.88q-.35-12.14-4.11-18.89T139,300.58a7.11,7.11,0,0,0-5.13,2.51,19.88,19.88,0,0,0-4.07,7.8,56,56,0,0,0-2.06,13.64l-.07,3.86A51.29,51.29,0,0,0,129.15,342q1.48,5.3,3.9,7.8A7.09,7.09,0,0,0,138.17,352.34Z\" /> " +
        " <path class=\"cls-1\" " +
        " d=\"M242.72,362.92a17.32,17.32,0,0,1-11.4-3.93,14,14,0,0,1-5.15-10.38q-.07-3.33-.07-7.33l.07-16.28q0-9.22-.55-15.54a19.64,19.64,0,0,0-2.24-7.53q-1.56-2.51-3.52-2.51-6.66.15-12.08,24-2.17,9.36-3.73,17.84-1.63,9-2.78,12.89-1.5,4.08-7.3,6.28a34.69,34.69,0,0,1-12.45,2.2,28,28,0,0,1-12.07-2.51q-5.35-2.5-5.77-7.87l-.13-8.27q0-9,.3-17.68t.31-17.53l-.07-6-.07-3.33a8.48,8.48,0,0,1,3-6.54,19.35,19.35,0,0,1,7.63-4,34.26,34.26,0,0,1,9.6-1.36,27.1,27.1,0,0,1,12,2.58q5.32,2.58,5.74,7.87l.06,6.51q0,10-.54,20.15l-.2,5.84q3.72-17.3,7.6-26.26,5.41-12,17.43-12a27.82,27.82,0,0,1,15.44,4.64q7.15,4.65,8.1,10.55.54,5.83.55,13,0,6-.21,12.14c-.09,3.67-.13,6.94-.13,9.84a37.58,37.58,0,0,0,.61,8.07c.4,1.68,1.1,2.51,2.1,2.51a4.08,4.08,0,0,0,2.58-1.29q3.72-3.87,7.22-13a80.9,80.9,0,0,0,4.51-15.3c.46-1.76,1.29-2.64,2.51-2.64,1.68.27,2.51,1.38,2.51,3.32v.48q-2,13-6.51,21.77t-10.24,12.62A22.5,22.5,0,0,1,242.72,362.92Z\" /> " +
        " <path class=\"cls-1\" " +
        " d=\"M285.93,365a24,24,0,0,1-8.85-1.56,9.65,9.65,0,0,1-5.53-4.95Q267,347.4,267,318.28q0-16.2,1.15-33.88t2.71-32.67q1.56-15,2.85-23.95a8.32,8.32,0,0,1,5.19-6.24,24.4,24.4,0,0,1,10.28-2,35.14,35.14,0,0,1,10.28,1.56,22.94,22.94,0,0,1,8.51,4.51,9.17,9.17,0,0,1,3.4,7.16l-.07,1.35q-1.5,11.19-3.29,39.72t-1.8,51.67q0,20,1.83,25.3a6.78,6.78,0,0,1,.41,2.24q0,3.47-3.46,6.17a25.42,25.42,0,0,1-8.65,4.24A36.67,36.67,0,0,1,285.93,365Z\" /> " +
        " <path class=\"cls-1\" " +
        " d=\"M326,360c-3.16,0-5.4-.73-6.72-2.17q-2.64-3.33-2.64-21,0-11.67,1-23.44t2.24-15.77c.36-.86,1.31-1.48,2.84-1.87a22.86,22.86,0,0,1,5.43-.57,38.77,38.77,0,0,1,6.79.61,25.08,25.08,0,0,1,5.8,1.66q2.34,1,2.34,2.55l-.07.4q-1,4.08-1.93,17.13t-.92,23.71q0,10.46,1.09,11.81a1.28,1.28,0,0,1,.33.81c0,.86-.82,1.76-2.47,2.68A27.87,27.87,0,0,1,333,359,25.91,25.91,0,0,1,326,360Zm7.67-67.1a9.29,9.29,0,0,1-4.72-1.32,9.66,9.66,0,0,1-3.66-3.94,13.44,13.44,0,0,1-1.39-6.41,23.39,23.39,0,0,1,.13-2.44c.55-3.89,1.82-6.76,3.84-8.62a9.5,9.5,0,0,1,6.54-2.78,9.4,9.4,0,0,1,4.89,1.39,10.56,10.56,0,0,1,3.76,4,12.73,12.73,0,0,1,1.46,6.34q-.47,7.53-4.07,10.92A9.87,9.87,0,0,1,333.63,292.91Z\" /> " +
        " <path class=\"cls-1\" " +
        " d=\"M427.52,362.92a17.32,17.32,0,0,1-11.4-3.93A14,14,0,0,1,411,348.61q-.08-3.33-.07-7.33L411,325q0-9.22-.54-15.54a19.82,19.82,0,0,0-2.24-7.53q-1.56-2.51-3.53-2.51-6.65.15-12.08,24-2.18,9.36-3.73,17.84-1.62,9-2.78,12.89-1.5,4.08-7.29,6.28a34.76,34.76,0,0,1-12.45,2.2,28,28,0,0,1-12.08-2.51q-5.36-2.5-5.77-7.87l-.13-8.27q0-9,.3-17.68t.31-17.53l-.07-6-.07-3.33a8.48,8.48,0,0,1,3-6.54,19.35,19.35,0,0,1,7.63-4,34.26,34.26,0,0,1,9.6-1.36,27.17,27.17,0,0,1,12,2.58q5.33,2.58,5.73,7.87l.07,6.51q0,10-.55,20.15l-.2,5.84q3.74-17.3,7.6-26.26,5.43-12,17.43-12a27.8,27.8,0,0,1,15.44,4.64q7.15,4.65,8.1,10.55.56,5.83.55,13,0,6-.21,12.14c-.09,3.67-.13,6.94-.13,9.84a37.58,37.58,0,0,0,.61,8.07c.41,1.68,1.11,2.51,2.1,2.51a4.08,4.08,0,0,0,2.58-1.29q3.74-3.87,7.23-13a82.42,82.42,0,0,0,4.51-15.3c.45-1.76,1.29-2.64,2.51-2.64,1.67.27,2.51,1.38,2.51,3.32v.48q-2,13-6.52,21.77t-10.24,12.62A22.5,22.5,0,0,1,427.52,362.92Z\" /> " +
        " <path class=\"cls-1\" " +
        " d=\"M479.69,355.26a27.2,27.2,0,0,1-23.95-14,32.64,32.64,0,0,1-3.93-16.49,28.53,28.53,0,0,1,2.61-12.45,29.57,29.57,0,0,1,6.85-9.29,30.58,30.58,0,0,1,9.33-5.84,27.37,27.37,0,0,1,10-2,20.76,20.76,0,0,1,8.08,1.59,15.83,15.83,0,0,1,6.37,4.86,16.39,16.39,0,0,1,3.26,10.24,21,21,0,0,1-1.46,7.67,14.9,14.9,0,0,1-4.41,6.17,11.25,11.25,0,0,1-7.43,2.44,10.17,10.17,0,0,1-3.05-.47,14,14,0,0,0-.34,3.66,42,42,0,0,0,.68,7.19,18,18,0,0,0,2.41,6.62,6,6,0,0,0,4.78,3q2.72,0,5.9-2.79a21,21,0,0,0,5.16-6.85,1.86,1.86,0,0,1,1.49-1.08,1.63,1.63,0,0,1,1.26.71,2.57,2.57,0,0,1,.57,1.66,2.53,2.53,0,0,1-.27,1.15,24.62,24.62,0,0,1-10.07,10.66A28,28,0,0,1,479.69,355.26Zm5.77-32.7a7.18,7.18,0,0,0,1.69-.2,8.11,8.11,0,0,0,5.3-3.67,11.44,11.44,0,0,0,1.49-5.7,14.45,14.45,0,0,0-1.42-6.71c-1-1.81-1.93-2.72-2.92-2.72q-1.91,0-3.63,3a30.06,30.06,0,0,0-2.85,6.82,23.52,23.52,0,0,0-1.12,6.41,4.89,4.89,0,0,0,.34,2A7.78,7.78,0,0,0,485.46,322.56Z\" /> " +
        " <path class=\"cls-2\" " +
        " d=\"M128.27,360.62a28,28,0,0,1-10.82-2.21,28.66,28.66,0,0,1-9.57-6.54,31.94,31.94,0,0,1-6.78-10.79,40.2,40.2,0,0,1-2.55-14.86q.14-11.73,5-19.54a30.8,30.8,0,0,1,11.39-11.16,29.15,29.15,0,0,1,14.25-3.83,26,26,0,0,1,13,3.46,26.29,26.29,0,0,1,10.08,10.72q4.28,7.74,4.41,20.22a44.58,44.58,0,0,1-2.38,15.26,30.42,30.42,0,0,1-6.41,10.75,26.87,26.87,0,0,1-19.57,8.52Zm9.9-8.28q3.2,0,6.31-3.19a23.61,23.61,0,0,0,5.12-9,43,43,0,0,0,2-13.88q-.35-12.14-4.11-18.89T139,300.58a7.11,7.11,0,0,0-5.13,2.51,19.88,19.88,0,0,0-4.07,7.8,56,56,0,0,0-2.06,13.64l-.07,3.86A51.29,51.29,0,0,0,129.15,342q1.48,5.3,3.9,7.8A7.09,7.09,0,0,0,138.17,352.34Z\" /> " +
        " <path class=\"cls-2\" " +
        " d=\"M242.72,362.92a17.32,17.32,0,0,1-11.4-3.93,14,14,0,0,1-5.15-10.38q-.07-3.33-.07-7.33l.07-16.28q0-9.22-.55-15.54a19.64,19.64,0,0,0-2.24-7.53q-1.56-2.51-3.52-2.51-6.66.15-12.08,24-2.17,9.36-3.73,17.84-1.63,9-2.78,12.89-1.5,4.08-7.3,6.28a34.69,34.69,0,0,1-12.45,2.2,28,28,0,0,1-12.07-2.51q-5.35-2.5-5.77-7.87l-.13-8.27q0-9,.3-17.68t.31-17.53l-.07-6-.07-3.33a8.48,8.48,0,0,1,3-6.54,19.35,19.35,0,0,1,7.63-4,34.26,34.26,0,0,1,9.6-1.36,27.1,27.1,0,0,1,12,2.58q5.32,2.58,5.74,7.87l.06,6.51q0,10-.54,20.15l-.2,5.84q3.72-17.3,7.6-26.26,5.41-12,17.43-12a27.82,27.82,0,0,1,15.44,4.64q7.15,4.65,8.1,10.55.54,5.83.55,13,0,6-.21,12.14c-.09,3.67-.13,6.94-.13,9.84a37.58,37.58,0,0,0,.61,8.07c.4,1.68,1.1,2.51,2.1,2.51a4.08,4.08,0,0,0,2.58-1.29q3.72-3.87,7.22-13a80.9,80.9,0,0,0,4.51-15.3c.46-1.76,1.29-2.64,2.51-2.64,1.68.27,2.51,1.38,2.51,3.32v.48q-2,13-6.51,21.77t-10.24,12.62A22.5,22.5,0,0,1,242.72,362.92Z\" /> " +
        " <path class=\"cls-2\" " +
        " d=\"M285.93,365a24,24,0,0,1-8.85-1.56,9.65,9.65,0,0,1-5.53-4.95Q267,347.4,267,318.28q0-16.2,1.15-33.88t2.71-32.67q1.56-15,2.85-23.95a8.32,8.32,0,0,1,5.19-6.24,24.4,24.4,0,0,1,10.28-2,35.14,35.14,0,0,1,10.28,1.56,22.94,22.94,0,0,1,8.51,4.51,9.17,9.17,0,0,1,3.4,7.16l-.07,1.35q-1.5,11.19-3.29,39.72t-1.8,51.67q0,20,1.83,25.3a6.78,6.78,0,0,1,.41,2.24q0,3.47-3.46,6.17a25.42,25.42,0,0,1-8.65,4.24A36.67,36.67,0,0,1,285.93,365Z\" /> " +
        " <path class=\"cls-2\" " +
        " d=\"M326,360c-3.16,0-5.4-.73-6.72-2.17q-2.64-3.33-2.64-21,0-11.67,1-23.44t2.24-15.77c.36-.86,1.31-1.48,2.84-1.87a22.86,22.86,0,0,1,5.43-.57,38.77,38.77,0,0,1,6.79.61,25.08,25.08,0,0,1,5.8,1.66q2.34,1,2.34,2.55l-.07.4q-1,4.08-1.93,17.13t-.92,23.71q0,10.46,1.09,11.81a1.28,1.28,0,0,1,.33.81c0,.86-.82,1.76-2.47,2.68A27.87,27.87,0,0,1,333,359,25.91,25.91,0,0,1,326,360Zm7.67-67.1a9.29,9.29,0,0,1-4.72-1.32,9.66,9.66,0,0,1-3.66-3.94,13.44,13.44,0,0,1-1.39-6.41,23.39,23.39,0,0,1,.13-2.44c.55-3.89,1.82-6.76,3.84-8.62a9.5,9.5,0,0,1,6.54-2.78,9.4,9.4,0,0,1,4.89,1.39,10.56,10.56,0,0,1,3.76,4,12.73,12.73,0,0,1,1.46,6.34q-.47,7.53-4.07,10.92A9.87,9.87,0,0,1,333.63,292.91Z\" /> " +
        " <path class=\"cls-2\" " +
        " d=\"M427.52,362.92a17.32,17.32,0,0,1-11.4-3.93A14,14,0,0,1,411,348.61q-.08-3.33-.07-7.33L411,325q0-9.22-.54-15.54a19.82,19.82,0,0,0-2.24-7.53q-1.56-2.51-3.53-2.51-6.65.15-12.08,24-2.18,9.36-3.73,17.84-1.62,9-2.78,12.89-1.5,4.08-7.29,6.28a34.76,34.76,0,0,1-12.45,2.2,28,28,0,0,1-12.08-2.51q-5.36-2.5-5.77-7.87l-.13-8.27q0-9,.3-17.68t.31-17.53l-.07-6-.07-3.33a8.48,8.48,0,0,1,3-6.54,19.35,19.35,0,0,1,7.63-4,34.26,34.26,0,0,1,9.6-1.36,27.17,27.17,0,0,1,12,2.58q5.33,2.58,5.73,7.87l.07,6.51q0,10-.55,20.15l-.2,5.84q3.74-17.3,7.6-26.26,5.43-12,17.43-12a27.8,27.8,0,0,1,15.44,4.64q7.15,4.65,8.1,10.55.56,5.83.55,13,0,6-.21,12.14c-.09,3.67-.13,6.94-.13,9.84a37.58,37.58,0,0,0,.61,8.07c.41,1.68,1.11,2.51,2.1,2.51a4.08,4.08,0,0,0,2.58-1.29q3.74-3.87,7.23-13a82.42,82.42,0,0,0,4.51-15.3c.45-1.76,1.29-2.64,2.51-2.64,1.67.27,2.51,1.38,2.51,3.32v.48q-2,13-6.52,21.77t-10.24,12.62A22.5,22.5,0,0,1,427.52,362.92Z\" /> " +
        " <path class=\"cls-2\" " +
        " d=\"M479.69,355.26a27.2,27.2,0,0,1-23.95-14,32.64,32.64,0,0,1-3.93-16.49,28.53,28.53,0,0,1,2.61-12.45,29.57,29.57,0,0,1,6.85-9.29,30.58,30.58,0,0,1,9.33-5.84,27.37,27.37,0,0,1,10-2,20.76,20.76,0,0,1,8.08,1.59,15.83,15.83,0,0,1,6.37,4.86,16.39,16.39,0,0,1,3.26,10.24,21,21,0,0,1-1.46,7.67,14.9,14.9,0,0,1-4.41,6.17,11.25,11.25,0,0,1-7.43,2.44,10.17,10.17,0,0,1-3.05-.47,14,14,0,0,0-.34,3.66,42,42,0,0,0,.68,7.19,18,18,0,0,0,2.41,6.62,6,6,0,0,0,4.78,3q2.72,0,5.9-2.79a21,21,0,0,0,5.16-6.85,1.86,1.86,0,0,1,1.49-1.08,1.63,1.63,0,0,1,1.26.71,2.57,2.57,0,0,1,.57,1.66,2.53,2.53,0,0,1-.27,1.15,24.62,24.62,0,0,1-10.07,10.66A28,28,0,0,1,479.69,355.26Zm5.77-32.7a7.18,7.18,0,0,0,1.69-.2,8.11,8.11,0,0,0,5.3-3.67,11.44,11.44,0,0,0,1.49-5.7,14.45,14.45,0,0,0-1.42-6.71c-1-1.81-1.93-2.72-2.92-2.72q-1.91,0-3.63,3a30.06,30.06,0,0,0-2.85,6.82,23.52,23.52,0,0,0-1.12,6.41,4.89,4.89,0,0,0,.34,2A7.78,7.78,0,0,0,485.46,322.56Z\" /> " +
        " <path class=\"cls-3\" " +
        " d=\"M35.23,393.9s88.61-23.34,217,4.45,260.24-19.46,260.24-19.46c-85.74,20.67-153.3,19-200,13.33C257.77,385.55,220.76,372,154.67,374A458.9,458.9,0,0,0,35.23,393.9Z\" /> " +
        " <path class=\"cls-1\" " +
        " d=\"M208,400.61c-24-4.11-56.24-9.86-98.06-2.77-23.91,4.05-37.78,10.28-37.78,10.28S86.05,404.47,110,403c46.45-2.87,81.13,4.56,98.06,7.92,30.8,6.1,76.74,11.55,140,6.85C273.31,414.75,240.12,406.11,208,400.61Z\" /> " +
        " <path class=\"cls-4\" " +
        " d=\"M250.83,18.07l-7.34-4H224.61a4.72,4.72,0,0,1-1.9,2.78,91.23,91.23,0,0,1,18.37,22.52,4.69,4.69,0,0,1,9.25-1.08H270.2l7.73-4.92H334.4a191.65,191.65,0,0,0-29.85-15.26Z\" /> " +
        " <path class=\"cls-5\" " +
        " d=\"M215.8,11a4.68,4.68,0,0,1,8.81.89h19.44l.06,0,7.28,4H299C275.19,7,249.38,2.26,222.37.43c-3.74-.25-8.64-1.72-10.6,2.73C210.05,7.08,213.08,9.06,215.8,11Z\" /> " +
        " <path class=\"cls-6\" " +
        " d=\"M270.84,40.42H250.33a4.67,4.67,0,0,1-7.28,2.73A63.42,63.42,0,0,1,247,53.57a4.68,4.68,0,0,1,8.93.59h21.5l16.5,10.5h49.66l-31.2-17.14h-21a4.7,4.7,0,1,1,0-2.17h21.51v.09l0-.09,35,19.22,0,.09h24a180.38,180.38,0,0,0-34-29.16H278.57Z\" /> " +
        " <path class=\"cls-7\" " +
        " d=\"M504.61,157.9c-19.44-22.6-44.38-37.4-71.43-49.28C413.41,99.94,394.24,92,379.33,73.44c-1.84-2.28-3.71-4.47-5.61-6.62H313.47l-17,10.84-.06-.09v.09h-21.5a4.7,4.7,0,1,1,0-2.17h20.93l13.63-8.68H293.23L276.75,56.32H255.88a4.67,4.67,0,0,1-7.74,2.35,66.63,66.63,0,0,1,1.1,13.76c-.11,4.69,1.61,8.12,5.38,11.12,41.67-3.57,56.12,2.8,56.12,2.8-14.56-4.09-51.83,0-51.83,0-64.65,7.34-112,36.85-143.2,90.57a73.83,73.83,0,0,0-9.44-15.23A61.69,61.69,0,0,0,86.84,145.6a52.5,52.5,0,0,0-24.92-6,66.31,66.31,0,0,0-19.73,3.27,61.82,61.82,0,0,0-19.73,10.47A57.49,57.49,0,0,0,7.06,172.2Q.91,183.81,0,200.42v.38a5.11,5.11,0,0,0,.91,3.27,2.54,2.54,0,0,0,2,1.13,2.27,2.27,0,0,0,1.79-1,5.87,5.87,0,0,0,1-3.15q1.13-18.81,9.78-30.92a47.47,47.47,0,0,1,21.86-17.19,37.62,37.62,0,0,1,13.43-2.73A28.41,28.41,0,0,1,68.25,156a47.67,47.67,0,0,1,13,15.51,83.51,83.51,0,0,1,8,21.93,114.56,114.56,0,0,1,2.73,25,110.17,110.17,0,0,1-2.88,25.2,74.48,74.48,0,0,1-8.92,22.12A47.64,47.64,0,0,1,65,281.46v-9.78q0-53-1.89-100a11,11,0,0,0-5.81-9.38,24.87,24.87,0,0,0-12.33-3,35.6,35.6,0,0,0-11.34,1.86,23.88,23.88,0,0,0-9.26,5.42,11.54,11.54,0,0,0-3.68,8.58v.45q1.89,46.37,1.9,98.11v8.88a26.69,26.69,0,0,1-8.43-6.45,2.34,2.34,0,0,0-1.67-.91,2.39,2.39,0,0,0-2,1.33,5.76,5.76,0,0,0-.83,3.15,6.4,6.4,0,0,0,1.06,3.64,34.19,34.19,0,0,0,11.76,8.73q-.3,35.06-2.12,64.34v.76a11.39,11.39,0,0,0,3.79,8.69,24.43,24.43,0,0,0,9.56,5.31A39,39,0,0,0,45.3,373,26.7,26.7,0,0,0,57,370.55q5.06-2.43,5.58-7.44,2-32.55,2.28-71.4,20.72-8.5,33.65-21.32a81.13,81.13,0,0,0,18.89-28,82.28,82.28,0,0,0,4.49-46.23l2.16-1a12.05,12.05,0,0,1,3-4.45c27.95-28.23,61.55-42.35,101.46-40.57,11.59.51,17.89,6.4,20.72,18.11,3.93,16.21-14.55,50-12.16,53.9,3,4.8,55.21-15,69.34-34.59,4.61-6.4,8.91-10.66,18-7.77,17.58,5.6,35,10.64,53.09,14a93.25,93.25,0,0,1-5.67-36.71c1-19.4,8.26-34.2,8.77-34.05s-6.4,15.22-5.67,34.78a84.77,84.77,0,0,0,10.7,37.36c7.59,1.17,15.31,2,23.22,2.48,31.95,1.79,61.24-1,90-13.54C515.22,177,516.42,171.62,504.61,157.9ZM369.84,128.75a44.47,44.47,0,0,0-1.68,8.28c-19.54-8-65.76-24-126.7-13.9a237.55,237.55,0,0,0-118.9,57c13.08-14.55,52.16-54.18,117.54-69a226.44,226.44,0,0,1,132.6,10.44A44,44,0,0,0,369.84,128.75ZM479,148.08c-.88,1.79-4.12,2-7.24.47s-4.93-4.22-4.05-6,4.11-2,7.23-.46S479.85,146.3,479,148.08Z\" /> " +
        " </g> " +
        " </g> " +
        " </svg> " +
        " </span> " +
        " </div> " +
        " </td> " +
        " </tr> " +
        " <tr> " +
        " <td width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" " +
        " style=\"box-sizing:border-box;font-family:-apple-system,BlinkMacSystemFont,'Segoe UI',Roboto,Helvetica,Arial,sans-serif,'Apple Color Emoji','Segoe UI Emoji','Segoe UI Symbol';background-color:#edf2f7;border-bottom:1px solid #edf2f7;border-top:1px solid #edf2f7;margin:0;padding:0;width:100%\"> " +
        " <table align=\"center\" width=\"570\" cellpadding=\"0\" cellspacing=\"0\" " +
        " style=\"box-sizing:border-box;font-family:-apple-system,BlinkMacSystemFont,'Segoe UI',Roboto,Helvetica,Arial,sans-serif,'Apple Color Emoji','Segoe UI Emoji','Segoe UI Symbol';background-color:#ffffff;border-color:#e8e5ef;border-radius:2px;border-width:1px;margin:0 auto;padding:0;width:570px\"> " +
        " <tbody> " +
        " <tr> " +
        " <td style=\"box-sizing:border-box;font-family:-apple-system,BlinkMacSystemFont,'Segoe UI',Roboto,Helvetica,Arial,sans-serif,'Apple Color Emoji','Segoe UI Emoji','Segoe UI Symbol';max-width:100vw;padding:32px\"> " +
        " " +
        " <!-- TITLE MAIL--> " +
        " <h1 id=\"title_mail\" " +
        " style=\"box-sizing:border-box;font-family:-apple-system,BlinkMacSystemFont,'Segoe UI',Roboto,Helvetica,Arial,sans-serif,'Apple Color Emoji','Segoe UI Emoji','Segoe UI Symbol';color:#3d4852;font-size:18px;font-weight:bold;margin-top:0;text-align:left\"> " +
        ponMailValTitle + " </h1> " +
    
        " <!-- TEXT BODY TOP --> " + 
        " <p id=\"text_body_top\" " +
        " style=\"box-sizing:border-box;font-family:-apple-system,BlinkMacSystemFont,'Segoe UI',Roboto,Helvetica,Arial,sans-serif,'Apple Color Emoji','Segoe UI Emoji','Segoe UI Symbol';font-size:16px;line-height:1.5em;margin-top:0;text-align:left\"> " +
        ponMailValBody1 + " </p> " +
        " <table align=\"center\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\"  " +
        " style=\"box-sizing:border-box;font-family:-apple-system,BlinkMacSystemFont,'Segoe UI',Roboto,Helvetica,Arial,sans-serif,'Apple Color Emoji','Segoe UI Emoji','Segoe UI Symbol';margin:30px auto;padding:0;text-align:center;width:100%\"> " +
        " <tbody> " +
        " <tr> " +
        " <td align=\"center\" " +
        " style=\"box-sizing:border-box;font-family:-apple-system,BlinkMacSystemFont,'Segoe UI',Roboto,Helvetica,Arial,sans-serif,'Apple Color Emoji','Segoe UI Emoji','Segoe UI Symbol'\"> " +
        " <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"        " +
        " style=\"box-sizing:border-box;font-family:-apple-system,BlinkMacSystemFont,'Segoe UI',Roboto,Helvetica,Arial,sans-serif,'Apple Color Emoji','Segoe UI Emoji','Segoe UI Symbol'\"> " +
        " <tbody> " +
        " <tr> " +
        " <td align=\"center\" " +
        " style=\"box-sizing:border-box;font-family:-apple-system,BlinkMacSystemFont,'Segoe UI',Roboto,Helvetica,Arial,sans-serif,'Apple Color Emoji','Segoe UI Emoji','Segoe UI Symbol'\"> " +
        " <table border=\"0\"   cellpadding=\"0\"     cellspacing=\"0\"     " +
        " style=\"box-sizing:border-box;font-family:-apple-system,BlinkMacSystemFont,'Segoe UI',Roboto,Helvetica,Arial,sans-serif,'Apple Color Emoji','Segoe UI Emoji','Segoe UI Symbol'\"> " +
        " <tbody> " +
        " <tr> " +
        " <td style=\"box-sizing:border-box;font-family:-apple-system,BlinkMacSystemFont,'Segoe UI',Roboto,Helvetica,Arial,sans-serif,'Apple Color Emoji','Segoe UI Emoji','Segoe UI Symbol'\"> " +
        " " +
        " <!-- MAIN BUTTON --> " +
        " <a id=\"main_button\" href=\" " + ponMailValLink + " \" " +
        " class=\"m_3193337105149806066button\" " +
        " rel=\"noopener\" " +
        " style=\"box-sizing:border-box;font-family:-apple-system,BlinkMacSystemFont,'Segoe UI',Roboto,Helvetica,Arial,sans-serif,'Apple Color Emoji','Segoe UI Emoji','Segoe UI Symbol';border-radius:4px;color:#fff;display:inline-block;overflow:hidden;text-decoration:none;background-color:#2d3748;border-bottom:8px solid #2d3748;border-left:18px solid #2d3748;border-right:18px solid #2d3748;border-top:8px solid #2d3748\" " +
        " target=\"_blank\" " +
        " > " +
        ponMailValLabelBtn +
        " </a> " +
        " </td> " +
        " </tr> " +
        " </tbody> " +
        " </table> " +
        " </td> " +
        " </tr> " +
        " </tbody> " +
        " </table> " +
        " </td> " +
        " </tr> " +
        " </tbody> " +
        " </table> " +
    
        " <!-- TEXT BODY --> " +
        " <p id=\"text_body1\" style=\"box-sizing:border-box;font-family:-apple-system,BlinkMacSystemFont,'Segoe UI',Roboto,Helvetica,Arial,sans-serif,'Apple Color Emoji','Segoe UI Emoji','Segoe UI Symbol';font-size:16px;line-height:1.5em;margin-top:0;text-align:left\"> " +
        ponMailValBody2  + " </p> " +
        " <p id=\"text_body2\" style=\"box-sizing:border-box;font-family:-apple-system,BlinkMacSystemFont,'Segoe UI',Roboto,Helvetica,Arial,sans-serif,'Apple Color Emoji','Segoe UI Emoji','Segoe UI Symbol';font-size:16px;line-height:1.5em;margin-top:0;text-align:left\"> " +
        ponMailValBody3  + " </p> " +
        " <p id=\"text_body3\" style=\"box-sizing:border-box;font-family:-apple-system,BlinkMacSystemFont,'Segoe UI',Roboto,Helvetica,Arial,sans-serif,'Apple Color Emoji','Segoe UI Emoji','Segoe UI Symbol';font-size:16px;line-height:1.5em;margin-top:0;text-align:left\"> " +
        " Regards,<br> " +
        " Ponline Teams</p> " +
        " <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" " +
        " style=\"box-sizing:border-box;font-family:-apple-syRstem,BlinkMacSystemFont,'Segoe UI',Roboto,Helvetica,Arial,sans-serif,'Apple Color Emoji','Segoe UI Emoji','Segoe UI Symbol';border-top:1px solid #e8e5ef;margin-top:25px;padding-top:25px\"> " +
        " <tbody> " +
        " <tr> " +
        " <td style=\"box-sizing:border-box;font-family:-apple-system,BlinkMacSystemFont,'Segoe UI',Roboto,Helvetica,Arial,sans-serif,'Apple Color Emoji','Segoe UI Emoji','Segoe UI Symbol'\"> " +
        " " +
        " <!-- TEXT BODY BOTTOM --> " +
        " <p id=\"text_body_botton\" style=\"box-sizing:border-box;font-family:-apple-system,BlinkMacSystemFont,'Segoe UI',Roboto,Helvetica,Arial,sans-serif,'Apple Color Emoji','Segoe UI Emoji','Segoe UI Symbol';line-height:1.5em;margin-top:0;text-align:left;font-size:14px\"> " +
        ponMailValBody4  + 
        " <span style=\"box-sizing:border-box;font-family:-apple-system,BlinkMacSystemFont,'Segoe UI',Roboto,Helvetica,Arial,sans-serif,'Apple Color Emoji','Segoe UI Emoji','Segoe UI Symbol';word-break:break-all\"> " +
        " " +
        " <!-- LINK RESET --> " +
        " <a id=\"main_link\"   href=\" "+ponMailValLink+" \" " +
        " style=\"box-sizing:border-box;font-family:-apple-system,BlinkMacSystemFont,'Segoe UI',Roboto,Helvetica,Arial,sans-serif,'Apple Color Emoji','Segoe UI Emoji','Segoe UI Symbol';color:#3869d4\" " +
        " target=\"_blank\" > " +
        "  "+ponMailValLink+" </a></span> " +
        " </p> " +
        " " +
        " </td> " +
        " </tr> " +
        " </tbody> " +
        " </table> " +
        " </td> " +
        " </tr> " +
        " </tbody> " +
        " </table> " +
        " </td> " +
        " </tr> " +
        " <tr> " +
        " <td " +
        " style=\"box-sizing:border-box;font-family:-apple-system,BlinkMacSystemFont,'Segoe UI',Roboto,Helvetica,Arial,sans-serif,'Apple Color Emoji','Segoe UI Emoji','Segoe UI Symbol'\"> " +
        " <table class=\"m_3193337105149806066footer\" align=\"center\" width=\"570\" " +
        " cellpadding=\"0\" cellspacing=\"0\"  " +
        " style=\"box-sizing:border-box;font-family:-apple-system,BlinkMacSystemFont,'Segoe UI',Roboto,Helvetica,Arial,sans-serif,'Apple Color Emoji','Segoe UI Emoji','Segoe UI Symbol';margin:0 auto;padding:0;text-align:center;width:570px\"> " +
        " <tbody> " +
        " <tr> " +
        " <td align=\"center\" " +
        " style=\"box-sizing:border-box;font-family:-apple-system,BlinkMacSystemFont,'Segoe UI',Roboto,Helvetica,Arial,sans-serif,'Apple Color Emoji','Segoe UI Emoji','Segoe UI Symbol';max-width:100vw;padding:32px\"> " +
        " <p id=\"text_footer\" " +
        " style=\"box-sizing:border-box;font-family:-apple-system,BlinkMacSystemFont,'Segoe UI',Roboto,Helvetica,Arial,sans-serif,'Apple Color Emoji','Segoe UI Emoji','Segoe UI Symbol';line-height:1.5em;margin-top:0;color:#b0adc5;font-size:12px;text-align:center\"> " +
        " © 2022 Ponline. All rights reserved.</p> " +
        " </td> " +
        " </tr> " +
        " </tbody> " +
        " </table> " +
        " </td> " +
        " </tr> " +
        " </tbody> " +
        " </table> " +
        " </td> " +
        " </tr> " +
        " </tbody> " +
        " </table> " +
        " </div> " +
        " </div> " +
        " </div> ";
        
        return content;
    }
    
    
}
