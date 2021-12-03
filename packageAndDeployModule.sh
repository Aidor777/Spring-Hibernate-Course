# Param to set the name of the app to the first CL argument
app_name=$1

sudo rm -f $app_name.war

# Copy library files
cp -r libs/* $app_name/WebContent/WEB-INF/lib/

cd $app_name/WebContent

# Package everything in the current folder (*) as a WAR file named $app_name.war
jar -cvf $app_name.war *

# Now we can remove libraries to make some space
sudo rm -f WEB-INF/lib/*

mv $app_name.war ..
cd ..

# Stop the server
sudo service tomcat9 stop

# Directory where my tomcat9 webapps are found
webapps_dir=/var/lib/tomcat9/webapps

# Remove existing assets (if any)
sudo rm -rf $webapps_dir/$app_name*

# Copy WAR file into place
sudo cp $app_name.war $webapps_dir
cd ..

# Starting the server will deploy our WAR :)
sudo service tomcat9 start