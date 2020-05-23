DROP TABLE IF EXISTS coupon,user;

CREATE TABLE IF NOT EXISTS coupon (
  couponCode VARCHAR(250) PRIMARY KEY,
  useYn VARCHAR(1) NOT NULL,
  giveYn VARCHAR(1) NOT NULL,
  userId VARCHAR(30),
  expireDate DATE NOT NULL,
  expireAlarmYn VARCHAR(1) NOT NULL,
  makeDate DATETIME NOT NULL
);

INSERT INTO COUPON (
			couponCode
			,useYn
			,giveYn
			,makeDate
			,expireDate
			,expireAlarmYn
		) VALUES (
			'testcode1'
			,'N'
			,'N'
			,NOW()
			,TODAY()+10
			,'N'
		);
		
INSERT INTO COUPON (
			couponCode
			,useYn
			,giveYn
			,makeDate
			,expireDate
			,expireAlarmYn
		) VALUES (
			'testcode2'
			,'N'
			,'Y'
			,NOW()
			,TODAY()+10
			,'N'
		);

CREATE TABLE user (
  userId VARCHAR(30) PRIMARY KEY,
  userPassword VARCHAR(100) NOT NULL,
  userName VARCHAR(50) NOT NULL
);

INSERT INTO user (
	userId
	,userPassword
	,userName
) VALUES (
	'test1'
	,'funzingogo'
	,'김일'
);

INSERT INTO user (
	userId
	,userPassword
	,userName
) VALUES (
	'test2'
	,'funzingogo'
	,'김이'
);
 