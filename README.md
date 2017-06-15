# keepmypci

Simple automation utility to login multiple ssh clients. I have to do it regularly because otherwise account would expire. thats it. Oh and sometimes i do not remember what my password is so added alt just in case.

[========]
## Config
Modify your [config.yaml](config.yaml "config.yaml"):
```yaml
hosts:
 - host1
 - host2
port: 22
user: user
pass: pass
alt: pass2
```

## Build
I use two tasks:
1. gradle eclipse run - to check real quick and update eclipse dependencies
2. gradle fatJar - to package everything into a single jar. Config should place next to it.

## Run
```shell
java -jar keepmypci-all-1.0.jar
```

