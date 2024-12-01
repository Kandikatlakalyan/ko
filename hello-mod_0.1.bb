SUMMARY = "Example of how to build an external Linux kernel module"
DESCRIPTION = "${SUMMARY}"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=12f884d2ae1ff87c09e5b7ccc2c4ca7e"

inherit module

SRC_URI = "file://hello.c \
           file://COPYING \
          "

S = "${WORKDIR}"
KERNEL_SRC ?= "${STAGING_KERNEL_DIR}"

do_compile() {
    # Compile the module without a Makefile
    oe_runmake -C ${KERNEL_SRC} M=${S} modules
}

RPROVIDES_${PN} += "kernel-module-hello"

