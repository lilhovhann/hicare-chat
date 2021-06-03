FROM registry.gitlab.com/armdev/dockers/openjdk15
COPY target/covidbot.jar /opt/covidbot.jar
RUN useradd -ms /bin/sh mphic2050 \
    && echo "root:Docker!" | chpasswd \
    && chown -R mphic2050 /opt/
USER mphic2050
ENTRYPOINT ["java", "-jar","/opt/covidbot.jar"]

EXPOSE 2021



