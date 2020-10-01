# Donald project template

This is a project template for a greenfield Java project. It's named after the Java mascot _Duke_. Given below are instructions on how to use it.

## Setting up in Intellij

Prerequisites: JDK 11, update Intellij to the most recent version.

1. Open Intellij (if you are not in the welcome screen, click `File` > `Close Project` to close the existing project dialog first)
1. Set up the correct JDK version, as follows:
   1. Click `Configure` > `Structure for New Projects` and then `Project Settings` > `Project` > `Project SDK`
   1. If JDK 11 is listed in the drop down, select it. If it is not, click `New...` and select the directory where you installed JDK 11
   1. Click `OK`
1. Import the project into Intellij as follows:
   1. Click `Open of Import`.
   1. Select the project directory, and click `OK`
   1. If there are any further prompts, accept the defaults.
1. After the importing is complete, locate the `src/main/java/Donald.java` file, right-click it, and choose `Run Donald.main()`. If the setup is correct, you should see something like the below:
   ```
   Hello from
                                        .;;;..
                                    ;<!!!!!!!!;
                                 .;!!!!!!!!!!!!>
                               .<!!!!!!!!!!!!!!!
                              ;!!!!!!!!!!!!!!!!'
                            ;!!!!!!!!!!!!!!!!!'
                           ;!!!!!!!!!!!!!!!''
                         ,!!!!!!!!!!!!!'' .::
                  ,;!',;!!!!!!!!!!!'' .::::''  .,,,,.
                 !!!!!!!!!!!!!!!''.::::' .,ndMMMMMMM,
                !!!!!!!!!!!!!' .::'' .,nMMP""',nn,'"MMbmnmn,.
                '!!!!!!!!!!` :'' ,unMMMM" xdMMMMMMMx'MMn
             _/  ''!!!!''`  ',udMMMMMM" nMMMMM??MMMM )MMMnur=
`,.... ......--~   ,       ,nMMMMMMMMMMnMMP".,ccc, "M MMMMP' ,,
 --......--   _.'        " MMP??4MMMMMP ,c$$$$$$$ ).MMMMnmMMM
     _.-' _..-~            =".,nmnMMMM .d$$$$$$$$$L MMMMMMMMMP
 .--~_.--~                  '."4MMMM  $$$$$$$$$$$',MMMMMPPMM
``\~~~~                      ,$$$h.'MM   '?$$$$$$$$P dMMMP , P
                           <$""?$ '"     $$$$$$$$',MMMP c$
                           '$c c$h       $$$$$$$',MMMM  $$
                            $$ $$$       $$$$$$',MMMMM  '?
                            '$.'$$$c.   z$???"  "',,'"
                             3h $$$$$cccccccccc$$$$$$$$$$$=r
                             $c'$$$$$$$$$$$$$$$??$$$$F"$$ "
                           ,mr'$c'$$$$$$$$$$$$$$c 3$$$$c$$
                        ,mMMMM."$.'?$$$$$$$$$$$$$$$$$$$$$$h,
;.   .               .uMMMMMMMM "$c,'"$$$$$$$$$$$$$$$$C,,,,cccccc,,..
!!;,;!!!!> .,,...  ,nMMMMMMMMMMM.'?$c  '"?$$$$$$$$$$$$$$$$$$$$$$$$$$$$h.
!!!!!!!!! uMM" <!!',dMMMMMMMMMMPP" ?$h.'::..'""???????""'..  -==cc,"?$$P
!!!!!!!!'.MMP <!',nMMMMMMMMP" .;    '$$c,''::::::::::::'.$F
!!!!!!!! JMP ;! JMMMMMMMP" .;!!'      "?$hc,.````````'.,$$
!!!!'''' 4M(;',dMMMP""" ,!!!!' ;;!!;.   "?$$$$$?????????"
!!! ::. 4b ,MM" .::: !''`` <!!!!!!!!;
 '!::::.'' 4M':::::'',mdP <!!!!!!!!!!!;
! :::::: ..  :::::: ""'' <!!!!!!!!!!!!!!;
!! ::::::.::: .::::: ;!!> <!!!!!!!!!!!!!!!!!;.
!! :::::: ::'::::::!!' <!!!!!!!!!!!!!!!!!!!!!;;.
! ::::::' .::::' ;!' .!!!!!!!!!!!!!!''!!!!!!!!!!!;.
; :::';!>  ::' ;<!.;!!!!!!!''''!!!!' <!! !!!!!!!!!!!>


   ```
