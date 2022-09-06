From openjdk:17
copy ./target/productcomment-0.0.1-SNAPSHOT.jar productcomment-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","productcomment-0.0.1-SNAPSHOT.jar"]