# SPRING BOOT DOCKER REST API

## Requirements


* [Java 17](https://access.redhat.com/documentation/en-us/openjdk/17/html-single/installing_and_using_openjdk_17_on_rhel/index)
* [Maven 3.5.0+](https://websetnet.net/install-apache-maven-3-5-on-centos-7/)
* [Docker](https://docs.docker.com/engine/install/centos/)
* [Docker-compose](https://docs.docker.com/compose/install/) 


## Build And Run

```bash
mvn clean install
```

```bash
docker image build -t productcomment .
```

```bash
docker compose up -d
```

## Explore Rest APIs

#### GET OPERATIONS

* Bir kullanıcının yapmış olduğu yorumları listelemek için
```bash
GET /api/commentsByUserID
```

* Bir ürün için yapılmış yorumları listeler
```bash
GET /api/commentsByProductID
```

* Belirli tarihler arasında bir ürün için yapılmış yorumları listeler
```bash
GET /api/commentsSpecificProductByDate
```

* Bir kullanıcının belirli tarihler arasında yapmış olduğu yorumları listeler
```bash
GET /api/commentsFromSpecificUserByDate
```

* Son kullanma tarihi geçmiş ürünleri listeler
```bash
GET /api/checkExpiredProducts
```

* Son kullanma tarihi geçmemiş ürünleri listeler (STT null olanlar da gelecek)
```bash
GET /api/checkExpireProducts
```


#### POST OPERATIONS


* Kullanıcı ekler

```bash
POST /api/addUser

       {
            "id": 1,
            "name": "aaa",
            "surname": "aaaa",
            "email": "sasa",
            "phoneNumber": "dada"
        }
```

* Ürün ekler

```bash
POST /api/addProduct

       {
            "name": "aaa",
            "price": 12.539999961853027,
            "expireDate": "2022-02-06"
        }
```


* Yorum ekler

```bash
POST /api/addComment

    {
        "comment": "Merhaba ben Hikmet !",
        "productID": 1,
        "userID":1
    }
```


#### PUT OPERATIONS

* Bir yorum güncellemek için

```bash
PUT /api/updateComment

     {
        "id": 6,
        "comment": "Merhaba ben Hikmet !",
        "productID": 1,
        "userID":1
    }
```

#### DELETE OPERATIONS

* Bir yorumu silmek için

```bash
PUT /api/comment/delete/{id}
```