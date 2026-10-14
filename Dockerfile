FROM ghcr.io/graalvm/graalvm-community:17 AS builder

COPY . /home/project
WORKDIR /home/project

RUN ./gradlew nativeCompile


FROM ubuntu

RUN apt-get update && apt-get install -y locales
RUN locale-gen "ko_KR.UTF-8"
ENV LANG=ko_KR.UTF-8
ENV LANGUAGE=ko_KR.UTF-8  
ENV LC_ALL=ko_KR.UTF-8

COPY --from=builder /home/project/build/native/nativeCompile /home/project
ENV PROFILE=proto

WORKDIR /home/project

ENTRYPOINT ["./share_template",  "--spring.profiles.active=${PROFILE}"]