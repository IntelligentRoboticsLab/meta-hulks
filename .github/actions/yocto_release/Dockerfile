FROM ubuntu:rolling

LABEL org.opencontainers.image.source https://github.com/HULKs/meta-hulks

# https://docs.yoctoproject.org/3.2.3/ref-manual/ref-system-requirements.html#ubuntu-and-debian (without some packages, with NodeJS)
RUN apt-get update && DEBIAN_FRONTEND=noninteractive TZ=Europe/Berlin apt-get install --no-install-recommends --yes \
    build-essential \
    chrpath \
    cpio \
    debianutils \
    diffstat \
    gawk \
    gcc-multilib \
    git-core \
    iputils-ping \
    nodejs \
    npm \
    python3 \
    python3-git \
    python3-jinja2 \
    python3-pexpect \
    python3-pip \
    python3-subunit \
    unzip \
    wget \
    xz-utils \
    && rm --recursive --force /var/lib/apt/lists/*

RUN git clone https://github.com/siemens/kas.git && cd kas && pip3 install --no-cache-dir .

COPY aldebaran_binaries.tar.gz /
