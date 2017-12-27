# mongoサーバ構築 やったこと

## ミドルウェアのインストール

### 動作確認用のWebサーバ インストール
```bash
# vi /etc/yum.repos.d/nginx.repo
# yum --enablerepo=nginx install nginx
```

### MongoDB Community版のインストール
```bash
# vi /etc/yum.repos.d/mongodb-org-3.6.repo
# yum install mongodb-org
Installing:
 mongodb-org                x86_64         3.6.0-1.el7           mongodb-org-3.6         5.8 k
Installing for dependencies:
 mongodb-org-mongos         x86_64         3.6.0-1.el7           mongodb-org-3.6          12 M
 mongodb-org-server         x86_64         3.6.0-1.el7           mongodb-org-3.6          20 M  
 mongodb-org-shell          x86_64         3.6.0-1.el7           mongodb-org-3.6          12 M  
 mongodb-org-tools          x86_64         3.6.0-1.el7           mongodb-org-3.6          46 M

# service mongod start
# tail -n 5 /var/log/mongodb/mongod.log
2017-12-07T11:49:06.485+0000 I STORAGE  [initandlisten] createCollection: local.startup_log with generated UUID: 74fd0b54-9177-4f07-838e-ce6d0ea8688f
2017-12-07T11:49:06.517+0000 I FTDC     [initandlisten] Initializing full-time diagnostic data capture with directory '/var/lib/mongo/diagnostic.data'
2017-12-07T11:49:06.518+0000 I NETWORK  [initandlisten] waiting for connections on port 27017
```

## いつもの面倒事排除
```bash
# setenforce 0 # selinux無効化
# vi /etc/selinux/config
-> SELINUX=disabled
```

```bash
# systemctl stop firewalld
# systemctl disable firewalld
```

## Mongoの簡易管理画面
```bash
# npm install admin-mongo
# cd node_module/admin-mongo
# npm install
# nohup npm start > log 2>&1 & 
```