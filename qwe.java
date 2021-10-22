
<!DOCTYPE html
  PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html><head>
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
   <!--
This HTML was auto-generated from MATLAB code.
To make changes, update the MATLAB code and republish this document.
      --><title>guideFractures</title><meta name="generator" content="MATLAB 9.6"><link rel="schema.DC" href="http://purl.org/dc/elements/1.1/"><meta name="DC.date" content="2020-06-09"><meta name="DC.source" content="guideFractures.m"><style type="text/css">
html,body,div,span,applet,object,iframe,h1,h2,h3,h4,h5,h6,p,blockquote,pre,a,abbr,acronym,address,big,cite,code,del,dfn,em,font,img,ins,kbd,q,s,samp,small,strike,strong,sub,sup,tt,var,b,u,i,center,dl,dt,dd,ol,ul,li,fieldset,form,label,legend,table,caption,tbody,tfoot,thead,tr,th,td{margin:0;padding:0;border:0;outline:0;font-size:100%;vertical-align:baseline;background:transparent}body{line-height:1}ol,ul{list-style:none}blockquote,q{quotes:none}blockquote:before,blockquote:after,q:before,q:after{content:'';content:none}:focus{outine:0}ins{text-decoration:none}del{text-decoration:line-through}table{border-collapse:collapse;border-spacing:0}

html { min-height:100%; margin-bottom:1px; }
html body { height:100%; margin:0px; font-family:Arial, Helvetica, sans-serif; font-size:10px; color:#000; line-height:140%; background:#fff none; overflow-y:scroll; }
html body td { vertical-align:top; text-align:left; }

h1 { padding:0px; margin:0px 0px 25px; font-family:Arial, Helvetica, sans-serif; font-size:1.5em; color:#d55000; line-height:100%; font-weight:normal; }
h2 { padding:0px; margin:0px 0px 8px; font-family:Arial, Helvetica, sans-serif; font-size:1.2em; color:#000; font-weight:bold; line-height:140%; border-bottom:1px solid #d6d4d4; display:block; }
h3 { padding:0px; margin:0px 0px 5px; font-family:Arial, Helvetica, sans-serif; font-size:1.1em; color:#000; font-weight:bold; line-height:140%; }

a { color:#005fce; text-decoration:none; }
a:hover { color:#005fce; text-decoration:underline; }
a:visited { color:#004aa0; text-decoration:none; }

p { padding:0px; margin:0px 0px 20px; }
img { padding:0px; margin:0px 0px 20px; border:none; }
p img, pre img, tt img, li img, h1 img, h2 img { margin-bottom:0px; } 

ul { padding:0px; margin:0px 0px 20px 23px; list-style:square; }
ul li { padding:0px; margin:0px 0px 7px 0px; }
ul li ul { padding:5px 0px 0px; margin:0px 0px 7px 23px; }
ul li ol li { list-style:decimal; }
ol { padding:0px; margin:0px 0px 20px 0px; list-style:decimal; }
ol li { padding:0px; margin:0px 0px 7px 23px; list-style-type:decimal; }
ol li ol { padding:5px 0px 0px; margin:0px 0px 7px 0px; }
ol li ol li { list-style-type:lower-alpha; }
ol li ul { padding-top:7px; }
ol li ul li { list-style:square; }

.content { font-size:1.2em; line-height:140%; padding: 20px; }

pre, code { font-size:12px; }
tt { font-size: 1.2em; }
pre { margin:0px 0px 20px; }
pre.codeinput { padding:10px; border:1px solid #d3d3d3; background:#f7f7f7; }
pre.codeoutput { padding:10px 11px; margin:0px 0px 20px; color:#4c4c4c; }
pre.error { color:red; }

@media print { pre.codeinput, pre.codeoutput { word-wrap:break-word; width:100%; } }

span.keyword { color:#0000FF }
span.comment { color:#228B22 }
span.string { color:#A020F0 }
span.untermstring { color:#B20000 }
span.syscmd { color:#B28C00 }

.footer { width:auto; padding:10px 0px; margin:25px 0px 0px; border-top:1px dotted #878787; font-size:0.8em; line-height:140%; font-style:italic; color:#878787; text-align:left; float:none; }
.footer p { margin:0px; }
.footer a { color:#878787; }
.footer a:hover { color:#878787; text-decoration:underline; }
.footer a:visited { color:#878787; }

table th { padding:7px 5px; text-align:left; vertical-align:middle; border: 1px solid #d6d4d4; font-weight:bold; }
table td { padding:7px 5px; text-align:left; vertical-align:top; border:1px solid #d6d4d4; }





  </style></head><body><div class="content"><h2>Contents</h2><div><ul><li><a href="#1">Reading DICOM files</a></li><li><a href="#6">Alignment of the forearm</a></li><li><a href="#7">Remove lines of collimator</a></li><li><a href="#10">Analysis based on the landmark of the radial styloid</a></li><li><a href="#13">Analysis based on the landmark of the lunate</a></li><li><a href="#15">Analysis of the texture a region of interest</a></li><li><a href="#16">Determine the ratio of trabecular / cortical to total bone</a></li></ul></div><h2 id="1">Reading DICOM files</h2><p>If your data is in DICOM format, you can read into Matlab using the functions dicomread and dicominfo like this</p><pre class="codeinput">dicom_header = dicominfo(<span class="string">'D:\OneDrive - City, University of London\Acad\Research\Exeter_Fracture\DICOM\Normals\N1\PAT1\STD1\SER1\IMG0'</span>);

dicom_image = dicomread(<span class="string">'D:\OneDrive - City, University of London\Acad\Research\Exeter_Fracture\DICOM\Normals\N1\PAT1\STD1\SER1\IMG0'</span>);
</pre><pre class="codeinput">dicom_header
</pre><pre class="codeoutput">
dicom_header = 

  struct with fields:

                                    Filename: 'D:\OneDrive - City, University of London\Acad\Research\Exeter_Fracture\DICOM\Normals\N1\PAT1\STD1\SER1\IMG0'
                                 FileModDate: '27-Jun-2017 11:19:50'
                                    FileSize: 1567164
                                      Format: 'DICOM'
                               FormatVersion: 3
                                       Width: 608
                                      Height: 1287
                                    BitDepth: 12
                                   ColorType: 'grayscale'
              FileMetaInformationGroupLength: 192
                  FileMetaInformationVersion: [2&times;1 uint8]
                     MediaStorageSOPClassUID: '1.2.840.10008.5.1.4.1.1.1'
                  MediaStorageSOPInstanceUID: '1.2.840.113773.4.10079.16033.20170627104914.197'
                           TransferSyntaxUID: '1.2.840.10008.1.2.1'
                      ImplementationClassUID: '1.2.840.113773.7.106'
                   ImplementationVersionName: '1.1.0.1'
                SourceApplicationEntityTitle: 'INCRYPT2'
                                   ImageType: 'ORIGINAL\PRIMARY\'
                                 SOPClassUID: '1.2.840.10008.5.1.4.1.1.1'
                              SOPInstanceUID: '1.2.840.113773.4.10079.16033.20170627104914.197'
                                   StudyDate: '20160811'
                                  SeriesDate: '20160811'
                             AcquisitionDate: '20160811'
                                 ContentDate: '20160811'
                                   StudyTime: '183100'
                                  SeriesTime: '184202.000000'
                             AcquisitionTime: '184202'
                                 ContentTime: '184202'
                             AccessionNumber: '---'
                                    Modality: 'CR'
                                Manufacturer: 'Philips Medical Systems'
                      ReferringPhysicianName: [1&times;1 struct]
                                 StationName: 'DiDiEleva01'
                            StudyDescription: 'XR Wrist Lt'
                           SeriesDescription: 'Lateral'
                 InstitutionalDepartmentName: 'Accident &amp; Emergency'
                       PhysicianReadingStudy: [1&times;1 struct]
                       ManufacturerModelName: 'DigitalDiagnost'
    ReferencedPerformedProcedureStepSequence: [1&times;1 struct]
                                 PatientName: [1&times;1 struct]
                                   PatientID: 'ANON9731'
                            PatientBirthDate: '20100713'
                                  PatientSex: 'F'
                              OtherPatientID: ''
                                  PatientAge: '006Y'
                                 PatientSize: 0
                               PatientWeight: 0
                               MedicalAlerts: ''
                           ContrastAllergies: ''
                                 EthnicGroup: ''
                             PregnancyStatus: 4
                            BodyPartExamined: 'HAND'
                                         KVP: 55
                          DeviceSerialNumber: '963334911417'
                             SoftwareVersion: '2.1.4\PMS81.101.1.1 GXR GXRIM7.0'
                                ProtocolName: 'Wrist L'
                           SpatialResolution: 0.1440
                                ExposureTime: 10
                                    Exposure: 3
                               ExposureInuAs: 2900
          ImageAndFluoroscopyAreaDoseProduct: 0.0900
                          ImagerPixelSpacing: [2&times;1 double]
                                        Grid: 'NONE'
      AcquisitionDeviceProcessingDescription: 'UNIQUE: S:200 L:4.0 SWL d:1.2 g:2.5 sb:4 eq:1 nr:0 dc:3 bal:0...'
                        RelativeXrayExposure: 751
                                ViewPosition: 'LL'
                            StudyInstanceUID: '1.2.840.113773.2.10079.999.20170627104911.56494'
                           SeriesInstanceUID: '1.2.840.113773.3.10079.16033.20170627104914.195'
                                     StudyID: '---'
                                SeriesNumber: 1
                              InstanceNumber: 1
                          PatientOrientation: 'A\H'
                                  Laterality: 'L'
                             SamplesPerPixel: 1
                   PhotometricInterpretation: 'MONOCHROME2'
                                        Rows: 1287
                                     Columns: 608
                                PixelSpacing: [2&times;1 double]
                               BitsAllocated: 16
                                  BitsStored: 12
                                     HighBit: 11
                         PixelRepresentation: 0
                         QualityControlImage: 'NO'
                          BurnedInAnnotation: 'NO'
                                WindowCenter: 2047
                                 WindowWidth: 4095
                            RescaleIntercept: 0
                                RescaleSlope: 1
                                 RescaleType: 'US'
                       LossyImageCompression: '00'
                         RequestingPhysician: [1&times;1 struct]
                           RequestingService: 'RH801ED'
               RequestedProcedureDescription: 'XR Wrist Lt'
              RequestedProcedureCodeSequence: [1&times;1 struct]
                     PerformedStationAETitle: 'RDE_ELEVA2'
             PerformedProcedureStepStartDate: '20160811'
             PerformedProcedureStepStartTime: '184128.109000'
                PerformedProcedureStepStatus: ''
           PerformedProcedureStepDescription: 'XR Wrist Lt'
               PerformedProtocolCodeSequence: [1&times;1 struct]
                      TotalNumberOfExposures: 2
                        ExposureDoseSequence: [1&times;1 struct]
                     FilmConsumptionSequence: [1&times;1 struct]
                        RequestedProcedureID: 'RH892825520'
                 ReasonForRequestedProcedure: ''
                  RequestedProcedurePriority: 'ROUTINE'
                PatientTransportArrangements: ''
          NamesOfIntendedRecipientsOfResults: [1&times;1 struct]
                  RequestedProcedureComments: ''
              ReasonForImagingServiceRequest: ''
            IssueDateOfImagingServiceRequest: ''
               ImagingServiceRequestComments: ''
                        PresentationLUTShape: 'IDENTITY'

</pre><pre class="codeinput">imagesc(dicom_image)
colormap <span class="string">gray</span>
</pre><img vspace="5" hspace="5" src="guideFractures_01.png" alt=""> <pre class="codeinput">clear
</pre><p>If you are going to handle numerous images, it can be convenient to read the dicom and then save in Matlab format as a *.mat file. You can save the header and the image into a single file, the image with the name "Xray" and the header with the name "Xray_info". Later on you can also add the mask (the three landmarks) as "Xray_mask". Then these can be loaded together from one file, e.g.</p><pre class="codeinput">clear
<span class="comment">%load('D:\OneDrive - City, University of London\Acad\Research\Exeter_Fracture\DICOM_Karen\ANON8865_PATIENT_PA_301.mat')</span>
load(<span class="string">'D:\OneDrive - City, University of London\Acad\Research\Exeter_Fracture\DICOM_Karen\ANON8845_PATIENT_PA_298.mat'</span>)

whos
</pre><pre class="codeoutput">  Name              Size                 Bytes  Class     Attributes

  Xray           2392x1792            34291712  double              
  Xray_info         1x1                  16690  struct              
  Xray_mask      2392x1792            34291712  double              

</pre><h2 id="6">Alignment of the forearm</h2><p>To rotate the Xray so that the forearm is aligned vertically, use the function alingXray. If you are already using a mask, the mask should also be b provided so that it is rotated with the same angle. The actual angle of rotation is one output parameter.</p><pre class="codeinput">[XrayR,Xray_maskR,angleRot]     = alignXray (Xray,Xray_mask);

disp(angleRot)

figure(1)
subplot(121)
imagesc(Xray)
subplot(122)
imagesc(XrayR)
</pre><pre class="codeoutput">    -6

</pre><img vspace="5" hspace="5" src="guideFractures_02.png" alt=""> <h2 id="7">Remove lines of collimator</h2><p>In case the image has lines due to the collimator and these should be removed, use the function removeEdgesCollimator. The function receives the Xray as input, and if desired a second parameter that controls the width of the removal, if the default does not work, try increasing it.</p><pre class="codeinput"><span class="comment">%load('D:\OneDrive - City, University of London\Acad\Research\Exeter_Fracture\DICOM_Karen\ANON8949_PATIENT_PA_594.mat')</span>


XrayR2                          = removeEdgesCollimator2(Xray);
figure(1)
subplot(121)
imagesc(Xray)
subplot(122)
imagesc(XrayR2)


XrayR2                          = removeEdgesCollimator2(Xray,90);
figure(2)
subplot(121)
imagesc(Xray)
subplot(122)
imagesc(XrayR2)
colormap <span class="string">gray</span>
</pre><img vspace="5" hspace="5" src="guideFractures_03.png" alt=""> <img vspace="5" hspace="5" src="guideFractures_04.png" alt=""> <pre class="codeinput">[XrayR,Xray_maskR,angleRot]     = alignXray (Xray,Xray_mask);
XrayR2                          = removeEdgesCollimator2(XrayR,70);
</pre><p>Notice that we are concatenating results: Xray -&gt; XrayR -&gt; XrayR2.</p><h2 id="10">Analysis based on the landmark of the radial styloid</h2><p>To determine two profiles from the radial styloid to the edge of the radius at 30 and 45 degrees below the line between the radial styloid and the lunate the function analyseLandmarkRadial is used in the following way:</p><pre class="codeinput">displayData                     = 1;
[stats,displayResultsRadial]    = analyseLandmarkRadial (XrayR2,Xray_maskR,Xray_info,<span class="string">'Case 1234'</span>,displayData);
</pre><img vspace="5" hspace="5" src="guideFractures_05.png" alt=""> <p>Notice that we have used the variable "displayData", which if set to 1, prompts the data to be displayed in a new figure. If it is set to 0 (or not passed as an input variable) no new figure is generated. In addition, the name of the case ('Case 1234') has been passed as an input.</p><p>The output variable 'stats' contain values about the lines (slope, standard deviation, etc)</p><pre class="codeinput">stats
</pre><pre class="codeoutput">
stats = 

  struct with fields:

          slope_1: 1.9149
          slope_2: 1.5220
    slope_short_1: 6.6215
    slope_short_2: 3.8167
            std_1: 243.0131
            std_2: 252.0656
         std_ad_1: 153.6793
         std_ad_2: 131.0886
          row_LBP: 1189
          col_LBP: 1060

</pre><p>In addition displayResultsRadial contains the actual profiles of the lines, as well as the data with the profiles and the landmarks.</p><pre class="codeinput">displayResultsRadial
</pre><pre class="codeoutput">
displayResultsRadial = 

  struct with fields:

     prof_radial_new1: [329&times;1 double]
     prof_radial_new2: [521&times;1 double]
    prof2_radial_new1: [329&times;1 double]
    prof2_radial_new2: [521&times;1 double]
           dataOutput: [2567&times;2033&times;3 double]
          dist_prof_1: 44.6530
          dist_prof_2: 58.4762

</pre><h2 id="13">Analysis based on the landmark of the lunate</h2><p>The landmark of the lunate is used to determine the forearm, and from there delineate the edges of the arm, and trace 8 lines that measure the width of the forearm, each at one cm of separation. The widths are displayed on the figure when you select to display.</p><pre class="codeinput">[edgesArm,widthAtCM,displayResultsLunate,dataOutput,coordinatesArm]    = analyseLandmarkLunate (XrayR2,Xray_maskR,Xray_info,<span class="string">'Case 1234'</span>,displayData);
</pre><img vspace="5" hspace="5" src="guideFractures_06.png" alt=""> <p>Of the previous output variables, edgesArm is a 2D matrix with the delineation of the arm, displayResultsLunate is a 2D matrix with the lines overlaid on the original Xray, dataOutput is the same, except that the lines are in red for better contrast. widthAtCM are the actual width of each line. coordinatesArm are the rows and columns that are used to crop the forearm.</p><h2 id="15">Analysis of the texture a region of interest</h2><p>A region of interest is detected and the Local Binary Pattern is calculated, the location of the region is selected as an intermediate point of the previously located profiles, so these are necessary input parameters.</p><pre class="codeinput">sizeInMM                        = [5, 5];
[LBP_Features,displayResultsLBP]    = ComputeLBPInPatch(XrayR2,Xray_info,Xray_maskR,stats.row_LBP,stats.col_LBP+50,sizeInMM,<span class="string">'Case 1234'</span>,displayData);
</pre><img vspace="5" hspace="5" src="guideFractures_07.png" alt=""> <h2 id="16">Determine the ratio of trabecular / cortical to total bone</h2><p>The analysis of the landmark of the central finger segments the bone according to the trabecular and cortical regions and then calculates the ratio.</p><pre class="codeinput">[TrabecularToTotal,WidthFinger,displayResultsFinger] = analyseLandmarkFinger (XrayR,Xray_maskR,Xray_info,<span class="string">'Case 1234'</span>,displayData);
</pre><img vspace="5" hspace="5" src="guideFractures_08.png" alt=""> <p class="footer"><br><a href="https://www.mathworks.com/products/matlab/">Published with MATLAB&reg; R2019a</a><br></p></div><!--
##### SOURCE BEGIN #####
%% Reading DICOM files
% If your data is in DICOM format, you can read into Matlab using the functions dicomread and dicominfo like
% this 

dicom_header = dicominfo('D:\OneDrive - City, University of London\Acad\Research\Exeter_Fracture\DICOM\Normals\N1\PAT1\STD1\SER1\IMG0');

dicom_image = dicomread('D:\OneDrive - City, University of London\Acad\Research\Exeter_Fracture\DICOM\Normals\N1\PAT1\STD1\SER1\IMG0');

%%
dicom_header

%%
imagesc(dicom_image)
colormap gray
%%

clear
%% 
% If you are going to handle numerous images, it can be convenient to read the dicom and then save in Matlab
% format as a *.mat file. You can save the header and the image into a single file, the image with the name
% "Xray" and the header with the name "Xray_info". Later on you can also add the mask (the three landmarks) as
% "Xray_mask". Then these can be loaded together from one file, e.g.
clear
%load('D:\OneDrive - City, University of London\Acad\Research\Exeter_Fracture\DICOM_Karen\ANON8865_PATIENT_PA_301.mat')
load('D:\OneDrive - City, University of London\Acad\Research\Exeter_Fracture\DICOM_Karen\ANON8845_PATIENT_PA_298.mat')
 
whos
%% Alignment of the forearm
% To rotate the Xray so that the forearm is aligned vertically, use the function alingXray. If you are already
% using a mask, the mask should also be b provided so that it is rotated with the same angle. The actual angle
% of rotation is one output parameter.

[XrayR,Xray_maskR,angleRot]     = alignXray (Xray,Xray_mask);

disp(angleRot)

figure(1)
subplot(121)
imagesc(Xray)
subplot(122)
imagesc(XrayR)

%% Remove lines of collimator
% In case the image has lines due to the collimator and these should be removed, use the function
% removeEdgesCollimator. The function receives the Xray as input, and if desired a second parameter that
% controls the width of the removal, if the default does not work, try increasing it.
%load('D:\OneDrive - City, University of London\Acad\Research\Exeter_Fracture\DICOM_Karen\ANON8949_PATIENT_PA_594.mat')


XrayR2                          = removeEdgesCollimator2(Xray);
figure(1)
subplot(121)
imagesc(Xray)
subplot(122)
imagesc(XrayR2)


XrayR2                          = removeEdgesCollimator2(Xray,90);
figure(2)
subplot(121)
imagesc(Xray)
subplot(122)
imagesc(XrayR2)
colormap gray


%%

[XrayR,Xray_maskR,angleRot]     = alignXray (Xray,Xray_mask);
XrayR2                          = removeEdgesCollimator2(XrayR,70);

%%
% Notice that we are concatenating results: Xray -> XrayR -> XrayR2.

%% Analysis based on the landmark of the radial styloid
% To determine two profiles from the radial styloid to the edge of the radius at 30
% and 45 degrees below the line between the radial styloid and the lunate the function analyseLandmarkRadial
% is used in the following way:

displayData                     = 1; 
[stats,displayResultsRadial]    = analyseLandmarkRadial (XrayR2,Xray_maskR,Xray_info,'Case 1234',displayData);

%%
% Notice that we have used the variable "displayData", which if set to 1, prompts the data to be displayed in
% a new figure. If it is set to 0 (or not passed as an input variable) no new figure is generated. In
% addition, the name of the case ('Case 1234') has been passed as an input.
% 
% The output variable 'stats' contain values about the lines (slope, standard deviation, etc)
stats

%%
% In addition displayResultsRadial contains the actual profiles of the lines, as well as the data with the
% profiles and the landmarks. 

displayResultsRadial


%% Analysis based on the landmark of the lunate
% The landmark of the lunate is used to determine the forearm, and from there delineate the edges of the arm,
% and trace 8 lines that measure the width of the forearm, each at one cm of separation. The widths are
% displayed on the figure when you select to display.
[edgesArm,widthAtCM,displayResultsLunate,dataOutput,coordinatesArm]    = analyseLandmarkLunate (XrayR2,Xray_maskR,Xray_info,'Case 1234',displayData);

%%
% Of the previous output variables, edgesArm is a 2D matrix with the delineation of the arm,
% displayResultsLunate is a 2D matrix with the lines overlaid on the original Xray, dataOutput is the same,
% except that the lines are in red for better contrast. widthAtCM are the actual width of each line.
% coordinatesArm are the rows and columns that are used to crop the forearm.
%% Analysis of the texture a region of interest 
% A region of interest is detected and the Local Binary Pattern is calculated, the location of the region is
% selected as an intermediate point of the previously located profiles, so these are necessary input
% parameters.
sizeInMM                        = [5, 5];
[LBP_Features,displayResultsLBP]    = ComputeLBPInPatch(XrayR2,Xray_info,Xray_maskR,stats.row_LBP,stats.col_LBP+50,sizeInMM,'Case 1234',displayData);


%% Determine the ratio of trabecular / cortical to total bone 
% The analysis of the landmark of the central finger segments the bone according to the trabecular and
% cortical regions and then calculates the ratio.

[TrabecularToTotal,WidthFinger,displayResultsFinger] = analyseLandmarkFinger (XrayR,Xray_maskR,Xray_info,'Case 1234',displayData);




##### SOURCE END #####
--></body></html>
