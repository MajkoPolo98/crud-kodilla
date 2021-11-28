call runcrud
if "%ERRORLEVEL%" == "0" goto showtasks
echo.
echo Cannot run crud.war
goto fail

:showtasks
call start firefox http://localhost:8080/crud/v1/task/getTasks
if "%ERRORLEVEL%" == "0" goto end
echo Cannot open browser

:fail
echo.
echo Operation unsuccessful

:end
echo.
echo Showed tasks successfully