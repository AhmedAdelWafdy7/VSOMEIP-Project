# LICENSE = "CLOSED"
# LIC_FILES_CHKSUM = ""

# SRC_URI = "https://github.com/AhmedAdelWafdy7/VSOMEIP-Project/tree/service_client_example;protocol=https;branch=main"

# SRCREV= "d94987a4b82dd807905225945acc2d12661f3811"

# RDEPENDS:${PN}="vsomeip"

# S = "${WORKDIR}/git"

# do_install() {
#    install -d ${D}/${datadir}/vsomeip-client-server
#    cp -r * ${D}/${datadir}/vsomeip-client-server/
# }

# FILES:${PN} += "${datadir}/vsomeip-client-server/*"


LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

SRC_URI = "https://github.com/AhmedAdelWafdy7/VSOMEIP-Project/tree/service_client_example.git;protocol=https;branch=main"
SRCREV = "d94987a4b82dd807905225945acc2d12661f3811"

DEPENDS="vsomeip"
RDEPENDS:${PN}="vsomeip"

S = "${WORKDIR}/git"

do_compile() {
    # Assuming the source file is hello_world_client_main.cpp
    ${CXX} ${LDFLAGS} -o hello_world_service hello_world_service_main.cpp -lvsomeip3
    ${CXX} ${LDFLAGS} -o hello_world_client hello_world_client_main.cpp -lvsomeip3
}

do_install() {
    install -d ${D}/${datadir}/vsomeip-client-server/build
    install -m 0755 hello_world_client ${D}/${datadir}/vsomeip-client-server/build
    install -m 0755 hello_world_service ${D}/${datadir}/vsomeip-client-server/build
    cp -r * ${D}/${datadir}/vsomeip-client-server/
}

FILES:${PN} += "${datadir}/vsomeip-client-server/*"
